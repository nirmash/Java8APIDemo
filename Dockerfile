# Use OpenJDK 8 as the base image
FROM openjdk:8-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the Maven configuration files
COPY pom.xml .
COPY src ./src

# Install Maven
RUN apk add --no-cache maven

# Build the application
RUN mvn package -DskipTests

# Set the JAR file as an environment variable
ENV JAR_FILE=target/java-service-0.0.1-SNAPSHOT.jar

# Copy the JAR file to the container
RUN cp ${JAR_FILE} app.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
