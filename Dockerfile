#Etapa de construcción
FROM maven:3.8.1-openjdk-17 as build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

ENV MYSQL_URL jdbc:mysql://localhost:3308/exampledb
ENV MYSQL_HOST localhost
ENV DATABASE_PORT 3308
ENV DATABASE_NAME exampledb
ENV MYSQL_USERNAME root
ENV MYSQL_PASSWORD admin
ENV DATABASE_DRIVER com.mysql.cj.jdbc.Driver
ENV DATABASE_PLATFORM org.hibernate.dialect.MySQL8Dialect

# COPY src ./src
RUN mvn package -DskipTests

# Etapa de ejecución
FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/calculator-backend-1.0.jar
COPY ${JAR_FILE} app_calculator-backend.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_calculator-backend.jar"]