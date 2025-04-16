#!/bin/bash

# Script to build and run the Java HTTP API Service using Docker Compose

# Set script to exit immediately if a command fails
set -e

# Print commands before executing them
set -x

echo "Building and starting Java HTTP API Service using Docker Compose..."

# Check if Docker Compose is installed
if ! command -v docker-compose &> /dev/null; then
    echo "Docker Compose is not installed. Please install Docker Compose first."
    exit 1
fi

# Build and start the services defined in docker-compose.yml
docker-compose up --build -d

echo "Java HTTP API Service is now running in the background."
echo "To view logs, run: docker-compose logs -f"
echo "To stop the service, run: docker-compose down"
