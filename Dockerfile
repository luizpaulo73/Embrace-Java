# ---------- ETAPA DE BUILD ----------
FROM ubuntu:latest AS build

# Atualiza o apt e instala JDK 17 + Maven
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven && \
    rm -rf /var/lib/apt/lists/*

# Define diretório de trabalho dentro do container para compilação
WORKDIR /app

# Copia pom.xml e pastas de código
COPY pom.xml .
COPY src ./src

# Executa o build do Maven (é aqui que será gerado o JAR em /app/target)
RUN mvn clean package -DskipTests

# ---------- ETAPA DE RUNTIME ----------
FROM openjdk:17-jdk-slim

# Expõe a porta que sua aplicação Spring Boot usa (8080, por padrão)
EXPOSE 8080

# Define diretório de trabalho para rodar o JAR
WORKDIR /app

# Copia o JAR gerado na etapa de build
# Atenção: aqui usamos o nome exato do JAR que o Maven gera
COPY --from=build /app/target/Embrace-0.0.1-SNAPSHOT.jar app.jar

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
