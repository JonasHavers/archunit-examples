package com.company.app.architecture;

import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.Test;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

public class SecondaryAdaptersComponentsTest extends ArchitectureTest {

  @Test
  public void repositoryClassesShouldBeAnnotatedWithRepositoryAnnotation() {
    ArchRule rule = ArchRuleDefinition.classes()
      .that().haveSimpleNameEndingWith("Repository")
      .and().areNotInterfaces()
      .should().beAnnotatedWith(Repository.class);
    rule.check(classes);
  }

  @Test
  public void noClassesWithRepositoryAnnotationShouldResideOutsideOfSecondaryAdaptersPackages() {
    ArchRule rule = ArchRuleDefinition.noClasses()
      .that().areAnnotatedWith(Repository.class)
      .should().resideOutsideOfPackage(SECONDARY_ADAPTERS_PACKAGES);
    rule.check(classes);
  }

  @Test
  public void documentClassesShouldBeAnnotatedWithDocumentAnnotation() {
    ArchRule rule = ArchRuleDefinition.classes()
      .that().haveSimpleNameEndingWith("Document")
      .should().beAnnotatedWith(Document.class);
    rule.check(classes);
  }

  @Test
  public void noClassesWithDocumentAnnotationShouldResideOutsideOfSecondaryAdaptersPackages() {
    ArchRule rule = ArchRuleDefinition.noClasses()
      .that().areAnnotatedWith(Document.class)
      .should().resideOutsideOfPackage(SECONDARY_ADAPTERS_PACKAGES);
    rule.check(classes);
  }
}
