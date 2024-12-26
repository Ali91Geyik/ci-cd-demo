# Build stage - Maven ile uygulamamızı derleyeceğiz
FROM maven:3.8.4-openjdk-17 AS builder
WORKDIR /build
# Önce pom.xml'i kopyalayıp bağımlılıkları indiriyoruz
COPY pom.xml .
# Bağımlılıkları ayrı bir layer olarak önbelleğe alıyoruz
RUN mvn dependency:go-offline

# Kaynak kodları kopyalayıp build işlemini gerçekleştiriyoruz
COPY src ./src
RUN mvn clean package -DskipTests

# Run stage - Sadece runtime için gerekli olan JDK ve JAR dosyasını içerecek
FROM openjdk:17-jdk-slim
WORKDIR /app
# Builder aşamasından JAR dosyasını kopyalıyoruz
COPY --from=builder /build/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]