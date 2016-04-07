# Parental Control Service

The task for this assignment is to create a parental control service for a video on demand platform.

## Continuous Integration
[![Build Status](https://travis-ci.org/nieldw/parental-control-service.svg?branch=master)](https://travis-ci.org/nieldw/parental-control-service)

Continuous Integration is set up using [Travis CI](https://travis-ci.org).

## Installation
This project only requires JDK 8. Install on linux using this command:

    sudo apt-get install openjdk-8-jdk

## Building
The Gradle build system was chosen because with the Gradle Wrapper it is possible to perform a build without any further
installation of third party software. Perform a build with this command:

    ./gradlew build
    
## Testing
Acceptance tests are written with cucumber-jvm. Feature files are found under `src/test/resources/features/`.
The acceptance tests are run as part of the build, and can be run using the `cucumber` gradle task:

    ./gradlew cucumber

Unit tests can be run with the `test` gradle task:

    ./gradlew test

To run both, use:

    ./gradlew check

## Design
The `ParentalControlService` requires a reference to a `MovieService` and a string `Comparator` to order parental 
control levels. This is necessary because levels have to be handled as strings. A `AdditionalMessageCallback` is used to
display messages to the user, for example, if an error occurs. This is necessary because of the requirement to return a 
boolean to the calling client and makes it possible to fail safely.

## Dependency Injection
The principle of Dependency Injection (DI) is followed throughout the system. DI is done manually. Using a framework 
would be overkill due to the simplicity of the system.

## Reference implementation
A reference implementation with a command line interface (CLI) is provided with a `FakeMovieService` in the
`nieldw.parental.control.ref` package to illustrate how the `ParentalControlService` may be used in a client.

### Running the Command Line Client
The CLI can be started by using the executing the `run` gradle task:

    ./gradlew --console plain run
