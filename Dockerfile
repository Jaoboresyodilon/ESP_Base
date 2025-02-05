# Étape 1 : Construire l'application avec Maven
FROM maven:3.8.6-openjdk-11 AS build
WORKDIR /app

# Copier uniquement les fichiers nécessaires pour accélérer la mise en cache
COPY pom.xml ./
RUN mvn dependency:go-offline

# Copier tout le projet après la mise en cache des dépendances
COPY . .

# Compiler l'application et générer le fichier JAR
RUN mvn clean package -DskipTests

# Étape 2 : Construire l'image finale avec OpenJDK léger
FROM openjdk:11-jdk-slim
WORKDIR /app

# Copier uniquement le fichier JAR généré depuis l'étape précédente
COPY --from=build /app/target/*.jar /app/app.jar

# Exposer le port d'exécution de l'application
EXPOSE 8080

# Démarrer l'application Spring Boot
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
