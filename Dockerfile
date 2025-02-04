# Importation du JDK et copie des fichiers requis
FROM openjdk:19-jdk AS build 
WORKDIR /app 
COPY pom.xml . 
COPY src src 

# Copie du wrapper Maven
 COPY mvnw . 
COPY .mvn .mvn 

# Définition des autorisations d'exécution pour le wrapper Maven
 RUN chmod +x ./mvnw 
RUN ./mvnw clean package -DskipTests 

# Étape 2 : Créer l'image Docker finale à l'aide d'OpenJDK 19
 FROM openjdk:19-jdk 
VOLUME /tmp 

# Copier le JAR à partir de l'étape de construction
 COPY --from=build /app/target/*.jar app.jar 
ENTRYPOINT [ "java" , "-jar" , "/app.jar" ] 
EXPOSE 8080