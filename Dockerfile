# Set base image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
#WORKDIR /app
VOLUME /tmp

# Copy the application jar file to the container
COPY target/spring-boot-labseq-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Set default command to run the application
CMD ["java", "-jar", "app.jar"]