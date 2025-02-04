# Étape 1 : Construction de l'application avec Maven
FROM openjdk:19-jdk AS build

# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier pom.xml et les sources
COPY pom.xml .
COPY src src
COPY mvnw .
COPY .mvn .mvn

# Donner les permissions d'exécution au wrapper Maven
RUN chmod +x ./mvnw

# Construire l'application et générer le fichier .jar
RUN ./mvnw clean package -DskipTests

# Vérifier que le fichier .jar est bien généré
RUN ls -l /app/target

# Étape 2 : Créer l'image finale
FROM openjdk:19-jdk

# Créer le répertoire /app dans l'image finale
RUN mkdir /app

# Copier le fichier .jar généré de l'étape de construction dans l'image finale
COPY --from=build /app/target/*.jar /app/app.jar

# Vérification que le fichier .jar existe bien dans le répertoire /app
RUN ls -l /app

# Définir la commande pour démarrer l'application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

# Exposer le port 8080 pour l'application Spring Boot
EXPOSE 8080
