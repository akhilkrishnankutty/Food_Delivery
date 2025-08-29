# Use a lightweight JDK image
FROM openjdk:26

# Set working directory inside container
WORKDIR /app

# Copy the jar (assuming built with `mvn clean package -DskipTests`)
COPY target/Food_delivery.jar app.jar

# Expose port
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
