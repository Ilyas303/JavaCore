# Используем официальный образ OpenJDK
FROM eclipse-temurin:21-jdk

# Рабочая директория
WORKDIR /app

# Копируем собранный JAR
COPY target/tv-catalog-0.0.1-SNAPSHOT.jar app.jar

# Копируем скрипт запуска
COPY entrypoint.sh .
RUN chmod +x entrypoint.sh

# Открываем порт
EXPOSE 8080

# Точка входа
ENTRYPOINT ["./entrypoint.sh"]