# Use a lightweight JDK base image
FROM eclipse-temurin:21-jammy

# Set the working directory
WORKDIR /app

# Copy the built jar file into the image and rename as app.jar
COPY target/merch-1.0-SNAPSHOT.jar app.jar

# Run the jar file as you would in the CLI
ENTRYPOINT ["java", "-jar", "app.jar"]