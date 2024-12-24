# Base image olarak JDK 17 kullanıyoruz
FROM openjdk:17-jdk-slim

# Çalışma dizinini belirliyoruz
WORKDIR /app

# JAR dosyasının adını bir değişkene atıyoruz
ARG JAR_FILE=target/*.jar

# JAR dosyasını container'a kopyalıyoruz
COPY ${JAR_FILE} application.jar

# Uygulamanın çalışacağı portu belirliyoruz
EXPOSE 8080

# Uygulamayı başlatıyoruz
ENTRYPOINT ["java", "-jar", "application.jar"]