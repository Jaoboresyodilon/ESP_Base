# Étape 1 : Construire l'application avec Maven
FROM openjdk:19-jdk AS build
WORKDIR /app

# Copier uniquement le fichier pom.xml et télécharger les dépendances pour optimiser le cache Docker
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

RUN chmod +x ./mvnw
RUN ./mvnw dependency:go-offline

# Copier le reste des fichiers du projet
COPY src src

# Exécuter la compilation du projet
RUN ./mvnw clean package -DskipTests

# Vérifier si le fichier .jar a bien été généré
RUN ls -l /app/target/

# Étape 2 : Créer l'image Docker finale
FROM openjdk:19-jdk
WORKDIR /app

# Créer le répertoire et copier le fichier JAR généré
RUN mkdir -p /app
COPY --from=build /app/target/*.jar /app/app.jar

# Vérifier que le fichier JAR a bien été copié (tu peux supprimer cette ligne une fois que tout fonctionne)
RUN ls -l /app/

# Exécuter l'application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

# Exposer le port 8080
EXPOSE 8080
