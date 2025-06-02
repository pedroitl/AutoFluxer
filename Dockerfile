# === STAGE 1: build ===
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# Copia o pom.xml e baixa dependências
COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN mvn dependency:go-offline

# Copia o código-fonte e empacota o JAR
COPY src src
RUN mvn package -DskipTests

# === STAGE 2: runtime ===
FROM eclipse-temurin:24-jre

WORKDIR /app

# Copia o JAR gerado no stage de build
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]