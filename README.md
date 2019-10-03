    Наименование проекта: trainingtask.
    
    Минимальные требования: openjdk-8-jdk
    
    Инструкция по сборке и запуску:
    
    1. Создание копии репозитория проекта:
    git clone https://git.qulix.com/ZagurskayaNL/trainingtask.git
    
    2. В gradle.properties настроить параметр запуска jdk org.gradle.java.home:
    Пример параметра для Windows:
    org.gradle.java.home=C:\\Program Files\\Java\\java-8-openjdk-amd64
    Пример параметра для Linux:
    org.gradle.java.home=/usr/lib/jvm/java-8-openjdk-amd64/
    
    2. Сборка проекта:
    gradlew build
    
    3. Запуск сервера базы данных:
    gradlew startDatabase
    
    4. Инициализация базы данных:
    gradlew initializationDatabase
        
    5. Запуск сервера приложений:
    gradlew startServer
    
    6. Запуск приложения:
    http://localhost:8080/trainingtask
    
    
    Примечание: 
    1. Для пользователей системы Linux 
    вместо команды "gradlew" использовать "./gradlew"
    
    2. Остановка сервера базы данных:
    gradlew stopDatabase
    
    3. Остановка сервера приложений:
    gradlew tomcatStop