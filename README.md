# Java HTTP API Service

A simple HTTP API built with Java 8 and Spring Boot.

## Features

- RESTful API endpoints
- Health check endpoint
- Message creation and retrieval
- Containerized with Docker

## Prerequisites

- Java 8 or higher
- Maven
- Docker (for containerization)

## Project Structure

```
java-service/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── javaservice/
│   │   │               ├── controller/
│   │   │               │   └── ApiController.java
│   │   │               ├── model/
│   │   │               │   ├── Message.java
│   │   │               │   └── Response.java
│   │   │               └── JavaServiceApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── application-docker.properties
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── javaservice/
│                       └── controller/
│                           └── ApiControllerTest.java
├── Dockerfile
├── docker-compose.yml
├── docker-compose-run.sh
├── docker-run.sh
├── run.sh
├── .gitignore
├── pom.xml
└── README.md
```

## Building and Running

### Option 1: Running Locally

#### Using the provided script:

```bash
./run.sh
```

#### Manually:

Build the application:
```bash
mvn clean package
```

Run the application:
```bash
java -jar target/java-service-0.0.1-SNAPSHOT.jar
```

The application will start on port 8080.

### Option 2: Using Docker

#### Using the provided script:

```bash
./docker-run.sh
```

#### Manually:

Build the Docker image:
```bash
docker build -t java-service:latest .
```

Run the Docker container:
```bash
docker run -p 8080:8080 java-service:latest
```

### Option 3: Using Docker Compose

#### Using the provided script:

```bash
./docker-compose-run.sh
```

#### Manually:

Build and run the application with Docker Compose:
```bash
docker-compose up -d
```

Stop the application:
```bash
docker-compose down
```

View logs:
```bash
docker-compose logs -f
```

## API Endpoints

### Health Check

```
GET /api/health
```

Returns a status message indicating the service is running.

### Create a Message

```
POST /api/message
Content-Type: application/json

{
  "content": "Hello, World!",
  "author": "John Doe"
}
```

Returns a response with the created message ID.

### Get a Message

```
GET /api/message/{id}
```

Returns the message with the specified ID if it exists.

## Example Usage

### Using curl

Health check:
```bash
curl -X GET http://localhost:8080/api/health
```

Create a message:
```bash
curl -X POST -H "Content-Type: application/json" -d '{"content":"Hello, World!","author":"John Doe"}' http://localhost:8080/api/message
```

Get a message (replace {id} with the actual ID):
```bash
curl -X GET http://localhost:8080/api/message/{id}
