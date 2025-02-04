# Étape 1 : Construction avec Maven
FROM openjdk:19-jdk AS build
WORKDIR /app
COPY pom.xml .
COPY src src
COPY mvnw . 
COPY .mvn .mvn

RUN chmod +x ./mvnw
RUN ./mvnw clean package -DskipTests

# Vérification que le fichier .jar est bien généré
RUN ls -l /app/target

# Étape 2 : Créer l'image finale
FROM openjdk:19-jdk
VOLUME /tmp

# Créer le répertoire /app dans l'image finale
RUN mkdir /app

# Copier le fichier .jar généré dans l'image finale
COPY --from=build /app/target/*.jar /app/app.jar

# Vérification de l'existence du fichier .jar dans le répertoire /app
RUN ls -l /app

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
EXPOSE 8080
