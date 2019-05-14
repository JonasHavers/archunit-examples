package com.company.app.architecture;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaClassList;
import com.tngtech.archunit.core.domain.JavaMethod;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.Test;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.function.Predicate;

public class ApplicationComponentsTest extends ArchitectureTest {

  @Test
  public void useCaseClassesShouldBeAnnotatedWithServiceAnnotation() {
    ArchRule rule = ArchRuleDefinition.classes()
      .that().haveSimpleNameEndingWith("UseCase")
      .should().beAnnotatedWith(Service.class);
    rule.check(classes);
  }

  @Test
  public void noUseCaseClassesShouldResideOutsideTheApplicationLayer() {
    ArchRule rule = ArchRuleDefinition.noClasses()
      .that().haveSimpleNameEndingWith("UseCase")
      .should().resideOutsideOfPackage(APPLICATION_LAYER_PACKAGES);
    rule.check(classes);
  }

  @Test
  public void noClassesWithServiceAnnotationShouldResideOutsideTheApplicationLayer() {
    ArchRule rule = ArchRuleDefinition.noClasses()
      .that().areAnnotatedWith(Service.class)
      .should().resideOutsideOfPackage(APPLICATION_LAYER_PACKAGES);
    rule.check(classes);
  }

  @Test
  public void useCaseClassesShouldHaveAnInvokeMethodWithASingleRequestParameterAndAResponseReturnType() {
    ArchRule rule = ArchRuleDefinition.classes()
      .that().haveSimpleNameEndingWith("UseCase")
      .should(new HaveAnInvokeMethodWithASingleRequestParameterAndAResponseReturnType());
    rule.check(classes);
  }

  class HaveAnInvokeMethodWithASingleRequestParameterAndAResponseReturnType extends ArchCondition<JavaClass> {

    HaveAnInvokeMethodWithASingleRequestParameterAndAResponseReturnType() {
      super("have an 'invoke' method with a single Request parameter and a Response return type");
    }

    @Override
    public void check(JavaClass clazz, ConditionEvents events) {
      Set<JavaMethod> methods = clazz.getMethods();
      Predicate<JavaMethod> hasMethodNamedInvoke = method -> method.getName().equals("invoke");
      if (methods.stream().filter(hasMethodNamedInvoke).count() != 1) {
        events.add(SimpleConditionEvent.violated(clazz, "${clazz.simpleName} does not have a single 'invoke' method"));
        return;
      }
      methods.stream().filter(hasMethodNamedInvoke).findFirst().ifPresent(invokeMethod -> {
        JavaClassList parameters = invokeMethod.getRawParameterTypes();
        if (parameters.size() != 1 || parameters.stream().noneMatch(it -> it.isInnerClass() && it.getSimpleName().equals("Request"))) {
          events.add(SimpleConditionEvent.violated(invokeMethod, "${clazz.simpleName}: method 'invoke' does not have a single parameter that is named 'request' and of inner-class type 'Request'"));
        }
        JavaClass returnType = invokeMethod.getRawReturnType();
        if (!returnType.isInnerClass() || !returnType.getSimpleName().equals("Response")) {
          events.add(SimpleConditionEvent.violated(invokeMethod, "${clazz.simpleName}: method 'invoke' does not have a return type that is of inner-class type 'Response'"));
        }
      });
    }

  }
}
