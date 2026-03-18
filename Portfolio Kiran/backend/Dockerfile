
FROM eclipse-temurin:17-jdk-focal AS builder
WORKDIR /app
COPY gradlew .
COPY gradle gradle
COPY build.gradle settings.gradle
COPY src src
RUN chmod +x gradlew
RUN ./gradlew bootJar -x test
FROM eclipse-temurin:17-jre-focal
WORKDIR /app
COPY --from=builder /app/build/libs/Billing-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 5050
ENTRYPOINT ["java", "-jar", "app.jar"]