# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/*.jar app.jar

# Expose the port the application runs on
EXPOSE 8083

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]