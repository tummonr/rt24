# RT24 Weather Sensor API
This project involves a Spring Boot application that provides an API for querying sensor data statistics. The system is built using Java 21, Spring Data JPA, and PostgreSQL, and it runs in a Docker container.
## Features
- Provides endpoints to query average, maximum, minimum, and sum statistics for sensor data between specified dates.
- Supports querying multiple sensors and metrics in a single request.
- Database migration management with Flyway.
## Structure
- **Model**: Represents the data structure using JPA entities.
- **Repository**: Interfaces with the database to perform CRUD operations.
- **Service**: Contains business logic for querying sensor statistics.
- **Controller**: Exposes REST endpoints for querying sensor data statistics.
## Tech Stack
- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Flyway
- Docker
  
### Setup and Installation
1. **Clone the Repository**
   
2. **Build the Project**:
    - Ensure you have the necessary environment set up **(i.e. Java 21 JDK needs to be installed, Docker Desktop etc.)**.
    - Use Gradle to build the jar: './gradlew clean build'

4. **Build and Run the Docker Container**: 'docker-compose up --build'
5. **Accessing the API**:
    - The application will be available at `http://localhost:8080/api/sensor-data/query`.
    - Use the query endpoint to fetch statistics for specific sensors and metrics.
    - I used postman for a simple GET request: ' http://localhost:8080/api/sensor-data/query?sensors=1,2,3&metrics=temperature,humidity&statistic=min&from=2024-11-25T00:00:00&to=2024-12-20T23:59:59 '
      ![query](https://github.com/user-attachments/assets/0be40f19-6072-45bb-8bf6-7f532c7689f7)

