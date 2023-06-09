

# Название проекта: Diplom

Проект представляет собой автоматизацию тестирования сервиса, взаимодействующего с СУБД и API Банка по вопросу приобретения пользователем тура с оплатой по дебетовой карте и в кредит.

## Начало работы

Для начала запуска проекта и тестов на локальном устройстве потребуется установить программы, описанные в разделе Prerequisites настоящего документа, а также выполнить следующие шаги:


1. Склонировать репозиторий на локальное устройство командой в Git:   
git clone https://github.com/OlgaBrazh/Diplom.git

2. Запустить Docker Desktop.
3. Запустить IntelliJ IDEA и открыть проект.

### Prerequisites

Git, JDK 11, IntelliJ IDEA, Docker


### Установка и запуск


1. Запустить контейнеры с базой данных (MySQL, PostgreSQL) и симулятором банковских сервисов: в терминале из корня проекта выполнить команду docker-compose up

2. Запустить SUT: в новой вкладке терминала из корня проекта выполнить команды 

2.1. для запуска SUT c использованием базы данных mysql:  
java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar

2.2. для запуска с использованием базы данных postgresql:  
java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar

3. Запустить автотесты: в новой вкладке терминала выполнить команды

3.1. для запуска тестов c использованием базы данных mysql:  
./gradlew clean test "-Ddb.url=jdbc:mysql://localhost:3306/app"

3.2. для запуска с использованием базы данных postgresql:  
./gradlew clean test "-Ddb.url=jdbc:postgresql://localhost:5432/app"

4. Для создания отчета Allure запустить команду   

//в настоящий момент подготовки дипломной работы allure еще не настроен, документы по отчетности проекта не сформированы


## Лицензия

*ОС - Windows 10 x64 для образовательных учреждений, версия 22Н2 

*версия Java: 11

[План тестирования](https://github.com/OlgaBrazh/Diplom/blob/main/docs/Plan.md)  

[Отчет о проведенном тестировании](https://github.com/OlgaBrazh/Diplom/blob/main/docs/Report.md)  

[Отчет о проведенной автоматизации](https://github.com/OlgaBrazh/Diplom/blob/main/docs/Summary.md)