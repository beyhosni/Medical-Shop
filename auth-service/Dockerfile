# Étape de construction
FROM openjdk:17-jdk-slim as build
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# Étape d'exécution
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/auth-service-*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
