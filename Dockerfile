FROM ubuntu:latest AS build

RUN apt-get update && apt-get install -y \
    openjdk-17-jdk \
    maven \
    wget \
    && apt-get clean

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean install

FROM ubuntu:latest

RUN apt-get update && apt-get install -y \
    openjdk-17-jdk \
    && apt-get clean

WORKDIR /app

COPY --from=build /app/target/Calculator-1.0-SNAPSHOT.jar .

CMD ["java", "-jar", "Calculator-1.0-SNAPSHOT.jar", "org.calculator.ScientificCalculator"]