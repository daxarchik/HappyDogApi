# Stage 1: Build the Spring Boot application
FROM maven:3.9.4-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /workspace

# Copy pom.xml and download dependencies (caches layer if pom unchanged)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Package the application
RUN mvn package -DskipTests -B


# Stage 2: Run the application
FROM eclipse-temurin:17-jdk-jammy

# Create a non-root user
RUN addgroup --system appgroup && adduser --system appuser --ingroup appgroup

# Expose application port
EXPOSE 8090

# Copy the JAR from build stage
COPY --from=build /workspace/target/*.jar /app/app.jar

# Change ownership and switch to non-root
RUN chown appuser:appgroup /app/app.jar
USER appuser

# Entry point
ENTRYPOINT ["java","-jar","/app/app.jar"]