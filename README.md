# archunit-examples

This repository contains some [ArchUnit](https://archunit.org) tests for a simplified book-catalog Spring Boot application.

A ports-and-adapters architecture was chosen to demonstrate many of the features of ArchUnit.

![PlantUML architecture.puml](http://www.plantuml.com/plantuml/png/dL3DQkCm4BxhAMQJImAnoR8i8Ki8yThu75ZsL7gOIEDKZIKPIIwKjkzU2Tkfsj9BqK4p-dw-6HsSH-jxrJB7iINucVzcp5saxj2Y0gazsGOvmHC3E26_dAtfjIXDQopCctKy4J5Ma1rVV_5mJkmbDU96TKQJzjyp-Y6eaPf06T6tjD2eQ0Nt-837u8HdMYO1Dn6zXTqkpnD6dk_tZ8twevKAxICK0hkme5i1ZbNU3T0IqC5OJooO5vjgKrUJop_YHeilVDm83avJzzbhCYkwhfKSlJGwkBmrKPxsCA_hOhqjsM89i_-EiX8TmT5OFulCtb5yYFqxHWfUCokZK8Ou4UyXQIX3I5bNVxUCVVo2y8sJ3Vo95PjMIpdF-tIGG9IgQqcHzcmIP-bIB5qmIxKf4iF70STinac7I6YCYLSKk0oroAwp59RVIK_SzvROWRJeLViA)

The [ArchUnit tests](src/test/java/com/company/app/architecture) can be found in the `com.company.app.architecture` package in `src/test/java`.
They can be executed as regular unit tests with `./gradlew test`. No ArchUnit JUnit runner was used in this example.

If you want to run the application, you can use the `docker-compose.yml` file to start a local docker MongoDB instance.
With `./gradlew bootRun` you execute the application itself.
There are also [HTTP tests](src/test/http/) in `src/test/http` which you can execute with IntelliJ IDEA to test the books API endpoints.
Of course, you can also use cURL. 
