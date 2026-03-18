# Base image with Java 17
FROM eclipse-temurin:17-jdk

# Set working directory inside container
WORKDIR /app

# Copy the JAR file from target folder
COPY target/*.jar app.jar

# Expose the port your Spring Boot app uses
EXPOSE 5050

# Run the Spring Boot JAR
ENTRYPOINT ["java","-jar","app.jar"]