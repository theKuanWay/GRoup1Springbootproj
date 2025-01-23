# Dockerfile
# FROM eclipse-temurin:17-jdk-jammy

# # Set working directory
# WORKDIR /app

# # Copy Maven wrapper and dependencies
# COPY .mvn/ .mvn
# COPY mvnw pom.xml ./

# # Copy source code
# COPY src ./src

# # Install dependencies and skip tests
# RUN ./mvnw install -DskipTests

# # Default command to run the application
# CMD ["./mvnw", "spring-boot:run"]

FROM eclipse-temurin:17-jdk-jammy

# Set working directory
WORKDIR /app

# Copy Maven dependencies and source code
COPY pom.xml .
RUN ./mvnw dependency:resolve
COPY src ./src

# Package the application
RUN ./mvnw clean package -DskipTests

# Run the Spring Boot JAR
CMD ["java", "-jar", "target/*.jar"]
