# ==========================================
# Stage 1 - Build
# ==========================================
FROM eclipse-temurin:17-jdk-jammy AS build

WORKDIR /app

# Copia o Maven Wrapper e o pom primeiro
# para aproveitar o cache das dependências
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./

# Garante permissão de execução no Maven Wrapper
RUN chmod +x mvnw

# Baixa as dependências
RUN ./mvnw -B dependency:go-offline

# Copia o código-fonte
COPY src/ src/

# Compila e gera o JAR
RUN ./mvnw -B clean package -DskipTests


# ==========================================
# Stage 2 - Runtime
# ==========================================
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Usuário sem privilégios
RUN useradd --system --create-home --shell /usr/sbin/nologin spring

# Copia o JAR gerado
COPY --from=build /app/target/*.jar app.jar

# Porta da aplicação
EXPOSE 8080

# Executa como usuário não-root
USER spring

ENTRYPOINT ["java", "-jar", "app.jar"]

