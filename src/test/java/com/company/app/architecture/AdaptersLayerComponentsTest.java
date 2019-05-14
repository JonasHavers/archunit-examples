package com.company.app.architecture;

import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.Test;
import org.springframework.context.annotation.Configuration;

public class AdaptersLayerComponentsTest extends ArchitectureTest {

  @Test
  public void configurationClassesShouldBeAnnotatedWithConfigurationAnnotation() {
    ArchRule rule = ArchRuleDefinition.classes()
      .that().haveSimpleNameEndingWith("Configuration")
      .should().beAnnotatedWith(Configuration.class);
    rule.check(classes);
  }

  @Test
  public void noClassesWithConfigurationAnnotationShouldResideOutsideOfAdaptersLayerPackages() {
    ArchRule rule = ArchRuleDefinition.noClasses()
      .that().areAnnotatedWith(Configuration.class)
      .should().resideOutsideOfPackage(ADAPTERS_LAYER_PACKAGES);
    rule.check(classes);
  }
}
