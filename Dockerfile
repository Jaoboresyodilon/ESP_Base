# Étape 1 : Build de l'application avec Maven (en utilisant JDK 11)
FROM maven:3.8.6-openjdk-11 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Étape 2 : Créer l'image finale avec Tomcat
FROM tomcat:9-jre11-slim

# Copier le fichier .war dans le dossier webapps de Tomcat
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/app.war

# Exposer le port 8080 (par défaut pour Tomcat)
EXPOSE 8080

# Définir la commande de démarrage de Tomcat
CMD ["catalina.sh", "run"]
