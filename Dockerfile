# Етап 1: збірка jar
FROM gradle:8.5-jdk17 AS build

# Копіюємо проєкт у контейнер з правами gradle
COPY --chown=gradle:gradle . /home/gradle/project
WORKDIR /home/gradle/project

# Видаємо права на gradlew ПЕРЕД запуском
RUN chmod +x ./gradlew

# Будуємо jar без тестів
RUN ./gradlew clean build -x test

# Етап 2: мінімальний образ для запуску
FROM openjdk:17-jdk-slim

# Копіюємо зібраний jar з попереднього етапу
COPY --from=build /home/gradle/project/build/libs/*.jar /app/app.jar

# Старт команди
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
