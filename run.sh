#!/bin/bash

# Script to build and run the Java HTTP API Service

# Set script to exit immediately if a command fails
set -e

# Print commands before executing them
set -x

echo "Building Java HTTP API Service..."

# Check if Maven is installed
if ! command -v mvn &> /dev/null; then
    echo "Maven is not installed. Please install Maven first."
    exit 1
fi

# Build the application
mvn clean package -DskipTests

echo "Starting Java HTTP API Service..."

# Run the application
java -jar target/java-service-0.0.1-SNAPSHOT.jar
