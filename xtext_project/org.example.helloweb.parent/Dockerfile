# Use a base image with Java and Maven installed for building
FROM maven:3.8.3-openjdk-17-slim AS builder

# Set the working directory
WORKDIR /app

# Copy the source code into the container
COPY . .

# Build the application
RUN mvn clean package -DskipTests

# Use a lightweight base image with Java installed for runtime
FROM openjdk:17-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the builder stage to the runtime stage
COPY --from=builder /app/org.example.helloweb.web/target/*.jar ./app.jar

# Expose the port used by your application
EXPOSE 8080

# Command to run your application
CMD ["java", "-cp", "app.jar", "org.example.helloweb.web.ServerLauncher"]
