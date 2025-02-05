# Étape 1 : Build de l'application avec Maven
FROM maven:3.8.6-openjdk-11 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Étape 2 : Image finale avec OpenJDK
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/*.jar /app/app.jar

# Exposer le bon port
EXPOSE 8080

# Lancer l’application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
