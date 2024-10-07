# Use a Maven image to build the project
FROM maven:3.9.9-eclipse-temurin-17 as build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file and the source code into the container
COPY pom.xml .
COPY src ./src

# Package the application with Maven
RUN mvn clean package

# Use a new lightweight image to run the application
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory in the new image
WORKDIR /app

# Copy the generated JAR file from the build stage
COPY --from=build /app/target/TodoListHibernate-1.0-SNAPSHOT.jar app.jar

# Expose the port your application will run on
EXPOSE 8080

# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
