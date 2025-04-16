#!/bin/bash

# Script to build and run the Java HTTP API Service using Docker

# Set script to exit immediately if a command fails
set -e

# Print commands before executing them
set -x

echo "Building Docker image for Java HTTP API Service..."

# Check if Docker is installed
if ! command -v docker &> /dev/null; then
    echo "Docker is not installed. Please install Docker first."
    exit 1
fi

# Build the Docker image
docker build -t java-service:latest .

echo "Starting Java HTTP API Service in Docker..."

# Run the Docker container
docker run -p 8080:8080 java-service:latest
