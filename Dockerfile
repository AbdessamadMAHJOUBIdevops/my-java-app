# ----- ÉTAPE 1: Le "Build" -----
# On utilise une image Maven officielle qui inclut Java 17
# C'est notre "builder" (notre constructeur)
FROM maven:3.9.6-eclipse-temurin-17-focal AS build

# On définit le dossier de travail dans le conteneur
WORKDIR /app

# On copie d'abord le pom.xml pour optimiser le cache Docker
COPY pom.xml .

# On copie le reste du code source
COPY src ./src

# On lance Maven pour packager l'application
# -DskipTests est optionnel, mais ton job Jenkins a DÉJÀ lancé les tests,
# pas besoin de les lancer une 2e fois ici.
RUN mvn clean package -DskipTests


# ----- ÉTAPE 2: L'image "Finale" -----
# On part d'une image Java 17 toute légère, sans Maven
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

# On copie SEULEMENT le .jar qui a été créé à l'étape "build"
COPY --from=build /app/target/*.jar ./app.jar

# C'est la commande qui sera lancée au démarrage du conteneur
# (Ex: quand tu feras "docker run ...")
CMD ["java", "-jar", "app.jar"]
