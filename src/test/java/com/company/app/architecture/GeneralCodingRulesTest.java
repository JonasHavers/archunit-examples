package com.company.app.architecture;

import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import com.tngtech.archunit.library.GeneralCodingRules;
import org.junit.Test;

public class GeneralCodingRulesTest extends ArchitectureTest {

  @Test
  public void noClassesShouldUseStandardStreams() {
    ArchRule rule = ArchRuleDefinition.noClasses()
      .should(GeneralCodingRules.ACCESS_STANDARD_STREAMS);
    rule.check(classes);
  }

  @Test
  public void noClassesShouldThrowGenericExceptions() {
    ArchRule rule = ArchRuleDefinition.noClasses()
      .should(GeneralCodingRules.THROW_GENERIC_EXCEPTIONS);
    rule.check(classes);
  }

  @Test
  public void noClassesShouldUseStandardLogging() {
    ArchRule rule = ArchRuleDefinition.noClasses()
      .should(GeneralCodingRules.USE_JAVA_UTIL_LOGGING);
    rule.check(classes);
  }
}
