package com.company.app.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.company.app")
public class BookCatalogApplication {

  public static void main(String[] args) {
    SpringApplication.run(BookCatalogApplication.class, args);
  }
}
