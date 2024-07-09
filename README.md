# Calculator Rest API Deployment Guide

## Prerequisites

- Java Development Kit (JDK) 11 or later
- Maven
- Docker

## Getting Started

### Running Locally

1. **Clone the repository:**

   ```sh
   git clone https://github.com/your-repo/your-project.git
   cd your-project/backend

2. **Configure your database connection and other properties:**

   spring:
	  sql:
	    init:
	      platform: mysql
	  datasource:
	    url: ${SPRING_DATASOURCE_URL:jdbc:mysql://localhost:3306/exampledb}
	    username: ${SPRING_DATASOURCE_USERNAME:root}
	    password: ${SPRING_DATASOURCE_PASSWORD:admin}
	    driver-class-name: ${DATABASE_DRIVER:com.mysql.cj.jdbc.Driver}
	  jpa:
	    properties:
	      show-sql: true
	      hibernate:
	        dialect: ${DATABASE_PLATFORM:org.hibernate.dialect.MySQL8Dialect}
	    hibernate:
	      ddl-auto: update
	  application:
	    name: calculator-backend
	server:
	  port: 8080

3. **Build the project:**
   mvn clean install

4. **Run the application:**
   mvn spring-boot:run
   
   
### Running in Docker

1. **Clone the repository:**

   ```sh
   git clone https://github.com/your-repo/your-project.git
   cd your-project/backend

2. **Create a docker-compose.yml file:**
   Ensure you have a docker-compose.yml file in the root directory with the     following content:
   
   version: '3.8'

	services:
	  app:
	    build: .
	    ports:
	      - "8080:8080"
	    restart: on-failure
	    environment:
	      - SPRING_DATASOURCE_URL=jdbc:mysql://mysqldb:3306/exampledb
	      - SPRING_DATASOURCE_USERNAME=root
	      - SPRING_DATASOURCE_PASSWORD=admin
	    depends_on:
	      mysqldb:
	        condition: service_healthy
	    networks:
	      - mynetwork
	  mysqldb:
	    image: mysql:8.0
	    environment:
	      - MYSQL_DATABASE=exampledb
	      - MYSQL_ROOT_PASSWORD=admin
	    ports:
	      - "3308:3306"
	    volumes:
	      - ./initdb:/docker-entrypoint-initdb.d
	    healthcheck:
	      test: ["CMD", "mysqladmin", "ping", "-h", "localhost"]
	    networks:
	      - mynetwork
	      
	networks:
	  mynetwork:
	    driver: bridge
   

3. **Create network:**
   docker network create mynetwork
   
3. **Build and run the Docker containers:**
   docker-compose up --build

4. **Access the API:**
   The backend will be running at http://localhost:8080.
   
   
### Test project

## Postman collection

Inside the docs folder, there is the Postman collection to perform some backend testing

**http://localhost:8080/api/operation**

Get the available operations and their cost
  
**http://localhost:8080/api/user/login**

Get the logged user

**http://localhost:8080/api/record/balance?userId=id**

Get the available balance of a user

**http://localhost:8080/api/record?userId=1&page=1&size=id**

Get the records of a user

**http://localhost:8081/api/operation**

Send an operation by the Calculator

**https://www.random.org/strings/?num=1&len=10&digits=on&unique=on&format=html&rnd=new**

Get a random string