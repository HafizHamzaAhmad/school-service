# School Service

School Service is a Java application developed using Spring Boot (version 3.2.2) and Java 21. It serves as a backend service for handling school, student and fees. The application utilizes an H2 database for data storage.

## Technologies

- Java 20
- Spring Boot 3.2.2
- H2 Database
- JUnit
- Swagger for API documentation
- Spring Boot Actuator for monitoring and managing application

## Features

1. **Swagger Documentation:**
    - API documentation is available through Swagger for easy exploration and integration.
    - Accessible at [http://localhost:8082/school-service/swagger-ui/index.html#/](http://localhost:8082/school-service/swagger-ui/index.html#/).

### Spring Boot Actuator

- Monitor and manage the application in production with Spring Boot Actuator.
- Endpoints include health, metrics, info, and more.
- Accessible at [http://localhost:8082/school-service/actuator](http://localhost:8082/school-service/actuator).

## Unit Test Cases

- JUnit test cases are implemented to ensure the reliability and correctness of the application.

## Endpoints

- **Fee Collection:**
    - POST `/collect-fee` - collect fees.

- **Fee Record:**
   - GET `/studentId/{studentId}` - fetch fees record of a student.

- **Grade:**
  - GET `/name/{name}` - gets the grade by name.
  - POST `` - create grade.
  - PUT `` - update student.

- **Student:**
   - GET `/studentId/{studentId}` - gets the student by id

    
## Setup

1. Clone the repository.
2. Configure your IDE or build tool for a Spring Boot application.
3. Run the application and access the Swagger documentation to explore the APIs.

# Getting Started

To get started with the project, follow these steps:

1. Clone the repository:

   ```bash
   git clone https://github.com/HafizHamzaAhmad/assessment.git

2. Build Application:

   ```bash
   mvn clean install

3. Run Application:

   ```bash
   java -jar school-0.0.1-SNAPSHOT.jar

4. Access Swagger:

   ```bash
   http://localhost:8083/school-service/swagger-ui/index.html#/
