package com.company.app.architecture;

import com.tngtech.archunit.library.dependencies.SliceRule;
import com.tngtech.archunit.library.dependencies.SlicesRuleDefinition;
import org.junit.Test;

public class SlicesTest extends ArchitectureTest {

  @Test
  public void layersShouldBeFreeOfCycles() {
    SliceRule rule = SlicesRuleDefinition.slices()
      .matching("com.company.app.(*)..")
      .should().beFreeOfCycles();
    rule.check(classes);
  }

  @Test
  public void adaptersShouldNotDependOnEachOther() {
    SliceRule rule = SlicesRuleDefinition.slices()
      .matching("com.company.app.adapters.(**)")
      .should().notDependOnEachOther();
    rule.check(classes);
  }
}
