#Use a maven image with java 23 to build the spring boot app
FROM eclipse-temurin:21-jdk AS build

#set the working directory
WORKDIR /app

#copy the maven wrapper and  pom.xml

COPY mvnw ./
COPY .mvn/ .mvn/

RUN chmod +x mvnw

COPY pom.xml ./
RUN ./mvnw dependency:go-offline

#copy the source code and build the application
COPY src ./src
RUN ./mvnw clean package -DskipTests

#use a java 21 run time image to run the application
FROM eclipse-temurin:21-jre

# Set the working directory
WORKDIR /app

#Copy the built JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Specify the command  to run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
