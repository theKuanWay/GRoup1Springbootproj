FROM openjdk:11
WORKDIR /app
COPY . ./
RUN ./mvnw clean package
CMD ["java","-jar","target/springbootproj-0.0.1-SNAPSHOT.jar"]
#env switch