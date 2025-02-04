# Étape 1 : Construire l'application avec Maven
FROM openjdk:19-jdk AS build
WORKDIR /app

# Copier le fichier pom.xml et les sources
COPY pom.xml .
COPY src /app/src

# Copier le wrapper Maven
COPY mvnw .
COPY .mvn .mvn

# Donner les autorisations d'exécution au wrapper Maven
RUN chmod +x ./mvnw

# Exécuter la commande Maven pour construire le projet (sans tester)
RUN ./mvnw clean package -DskipTests

# Vérification du contenu du dossier target pour s'assurer que le fichier .jar existe
RUN ls -l /app/target/

# Étape 2 : Créer l'image Docker finale à partir du JDK
FROM openjdk:19-jdk
VOLUME /tmp

# Copier le fichier .jar généré par l'étape de build
COPY --from=build /app/target/*.jar /app/app.jar

# Définir la commande de démarrage du container
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

# Exposer le port utilisé par l'application (8080 par défaut pour Spring Boot)
EXPOSE 8080
