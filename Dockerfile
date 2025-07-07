FROM maven:3.8-openjdk-17 AS builder

WORKDIR /app

COPY app/pom.xml .
RUN mvn dependency:go-offline

COPY app/src ./src

RUN mvn package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
