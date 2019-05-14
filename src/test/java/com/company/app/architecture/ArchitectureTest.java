package com.company.app.architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.BeforeClass;

public abstract class ArchitectureTest {
  static final String DOMAIN_LAYER_PACKAGES = "com.company.app.domain..";
  static final String APPLICATION_LAYER_PACKAGES = "com.company.app.application..";
  static final String ADAPTERS_LAYER_PACKAGES = "com.company.app.adapters..";
  static final String PRIMARY_ADAPTERS_PACKAGES = "com.company.app.adapters.primary..";
  static final String SECONDARY_ADAPTERS_PACKAGES = "com.company.app.adapters.secondary..";

  static JavaClasses classes;

  @BeforeClass
  public static void setUp() {
    classes = new ClassFileImporter()
      .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
      .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_ARCHIVES)
      .importPackages("com.company.app");
  }
}
