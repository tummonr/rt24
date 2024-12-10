# Use a base image that supports Java 21
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the Spring Boot jar to the container
COPY build/libs/rt24-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]