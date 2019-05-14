# archunit-examples

This repository contains some [ArchUnit](https://archunit.org) tests for a simplified book-catalog Spring Boot application.

A ports-and-adapters architecture was chosen to demonstrate many of the features of ArchUnit.

The [ArchUnit tests](src/test/java/com/company/app/architecture) can be found in the `com.company.app.architecture` package in `src/test/java`.
They can be executed as regular unit tests with `./gradlew test`. No ArchUnit JUnit runner was used in this example.

If you want to run the application, you can use the `docker-compose.yml` file to start a local docker MongoDB instance.
With `./gradlew bootRun` you execute the application itself.
There are also [HTTP tests](src/test/http/) in `src/test/http` which you can execute with IntelliJ IDEA to test the books API endpoints.
Of course, you can also use cURL. 
