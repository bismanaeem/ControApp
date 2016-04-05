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