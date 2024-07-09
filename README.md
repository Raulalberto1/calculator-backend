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
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update

3. **Build the project:**
   mvn clean install

4. **Run the application:**
   mvn spring-boot:run
   
   
### Running Locally

1. **Clone the repository:**

   ```sh
   git clone https://github.com/your-repo/your-project.git
   cd your-project/backend

2. **Create a docker-compose.yml file:**
   Ensure you have a docker-compose.yml file in the root directory with the     following content:
   
   version: '3.8'

services:
  db:
    image: mysql:8.0
    container_name: mysql-db
    environment:
      MYSQL_ROOT_PASSWORD: admin
      MYSQL_DATABASE: exampledb
    ports:
      - "3308:3306"
    volumes:
      - ./initdb:/docker-entrypoint-initdb.d
    networks:
      - app-network
      
  backend:
    build: .
    container_name: backend-app
    ports:
      - "8080:8080"
    environment:
      - MYSQL_URL=jdbc:mysql://localhost:3308/exampledb
      - MYSQL_HOST=localhost
      - MYSQL_USERNAME=root
      - MYSQL_PASSWORD=admin
      - DATABASE_NAME=exampledb
      - DATABASE_PORT=3308
    depends_on:
      - db
    networks:
      - app-network

networks:
  app-network:

   

3. **Build and run the Docker containers:**
   docker-compose up --build

4. **Access the API:**
   The backend will be running at http://localhost:8080.
   