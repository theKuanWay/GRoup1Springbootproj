# Dockerfile
FROM eclipse-temurin:17-jdk-jammy

# Set working directory
WORKDIR /app

# Copy Maven wrapper and dependencies
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Copy source code
COPY src ./src

# Install dependencies and skip tests
RUN ./mvnw install -DskipTests

# Default command to run the application
CMD ["./mvnw", "spring-boot:run"]

