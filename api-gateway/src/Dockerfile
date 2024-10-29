# Utilisez une image Java pour construire l'application
FROM openjdk:23-jdk-slim as build
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# Image pour exécuter l'application
FROM openjdk:23-jdk-slim
WORKDIR /app
COPY --from=build /app/target/api-gateway-*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
