# Étape 1 : Construire l'application avec Maven
FROM openjdk:19-jdk AS build
WORKDIR /app

# Copier les fichiers nécessaires pour Maven
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Télécharger les dépendances (optimisation du cache)
RUN chmod +x ./mvnw
RUN ./mvnw dependency:go-offline

# Copier les sources et compiler l'application
COPY src src
RUN ./mvnw clean package -DskipTests

# Vérifier si le .jar est bien généré
RUN ls -l /app/target/

# Étape 2 : Construire l'image finale
FROM openjdk:19-jdk
WORKDIR /app

# Assurer que le dossier existe
RUN mkdir -p /app

# Copier le .jar correctement et vérifier son existence
COPY --from=build /app/target/*.jar /app/app.jar
RUN ls -l /app/

# Exposer le port 8080
EXPOSE 8080

# Lancer l'application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
