FROM maven:3.9.2-eclipse-temurin-17 AS build
WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests
FROM openjdk:17-jdk-slim
WORKDIR /app

COPY --from=build /app/target/Calculator-1.0-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]
