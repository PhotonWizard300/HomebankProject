# Подготовка к запуску тестов и генерация отчёта Allure

### Необходимо установиь для работы:

1. JDK 8 версии для работы Appium Server и Android Studio: https://www.oracle.com/cis/java/technologies/javase/javase8-archive-downloads.html
2. Appium Server Desktop: https://github.com/appium/appium-desktop/releases
3. Для запуска тестов на эмуляторе Android: https://developer.android.com/studio

### Загрузка и настройка проекта:

1. Склонируйте проект с GitLab репозитория: git clone http://gitlab.cloud.halykbank.nb/qa-automation-tests/homebank.git
2. Установите зависимости Gradle для работы с фреймворком JUnit, Allure. Все зависимости описаны в файле build.gradle

## Запуск автотестов

Для запуска автотестов необходимо прописать команду - ./gradlew test. Перед запуском убедитесь, что Appium Server и Emulator Android запущены.
Если вы хотите запустить определённый тест-класс - ./gradlew test Login (Login - название тестового класса).

## Генерация отчёта 

После выполнения тестов сформируется папка allure-results, которая содержит результаты тестирования. Используя команду allure generate allure-results
произойдёт генерация отчёта Allure и создание папки allure-report. После этого, чтобы открыть сформированный отчёт выполните команду allure open allure-report.

Пример отчёта: 
![img.png](img.png)