# Étape de construction
FROM openjdk:23-jdk-slim as build
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# Étape d'exécution
FROM openjdk:23-jdk-slim
WORKDIR /app
COPY --from=build /app/target/product-service-*.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]
