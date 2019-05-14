package com.company.app.architecture;

import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

public class PrimaryAdaptersComponentsTest extends ArchitectureTest {

  @Test
  public void controllerClassesShouldBeAnnotatedWithControllerOrRestControllerAnnotation() {
    ArchRule rule = ArchRuleDefinition.classes()
      .that().haveSimpleNameEndingWith("Controller")
      .should().beAnnotatedWith(Controller.class)
      .orShould().beAnnotatedWith(RestController.class);
    rule.check(classes);
  }

  @Test
  public void noClassesWithControllerOrRestControllerAnnotationShouldResideOutsideOfPrimaryAdaptersPackages() {
    ArchRule rule = ArchRuleDefinition.noClasses()
      .that().areAnnotatedWith(Controller.class)
      .or().areAnnotatedWith(RestController.class)
      .should().resideOutsideOfPackage(PRIMARY_ADAPTERS_PACKAGES);
    rule.check(classes);
  }

  @Test
  public void controllerClassesShouldNotDependOnEachOther() {
    ArchRule rule = ArchRuleDefinition.noClasses()
      .that().haveSimpleNameEndingWith("Controller")
      .should().dependOnClassesThat().haveSimpleNameEndingWith("Controller");
    rule.check(classes);
  }

  @Test
  public void publicControllerMethodsShouldBeAnnotatedWithARequestMapping() {
    ArchRule rule = ArchRuleDefinition.methods()
      .that().arePublic()
      .and().areDeclaredInClassesThat().resideInAPackage("..adapters.primary.web..")
      .and().areDeclaredInClassesThat().haveSimpleNameEndingWith("Controller")
      .and().areDeclaredInClassesThat().areAnnotatedWith(Controller.class)
      .or().areDeclaredInClassesThat().areAnnotatedWith(RestController.class)
      .should().beAnnotatedWith(RequestMapping.class)
      .orShould().beAnnotatedWith(GetMapping.class)
      .orShould().beAnnotatedWith(PostMapping.class)
      .orShould().beAnnotatedWith(PatchMapping.class)
      .orShould().beAnnotatedWith(DeleteMapping.class);
    rule.check(classes);
  }
}
