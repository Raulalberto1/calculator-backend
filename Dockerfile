# Use a base image with Java 17
FROM openjdk:17

# COPY src ./src
#RUN mvn package -DskipTests

# Copy the JAR package into the image
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Expose the application port
EXPOSE 8080

ENV MYSQL_DATABASE exampledb
ENV MYSQL_PASSWORD admin

# Run the App
ENTRYPOINT ["java", "-jar", "/app.jar"]