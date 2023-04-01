# Планирование автоматизации тестирования

## Перечень автоматизируемых сценариев

#### Позитивные сценарии
1. Покупка тура с оплатой по дебетовой карте
2. Покупка тура с оплатой кредитными средствами

#### Негативные сценарии
1. Покупка тура при недостаточности средств на дебетовой карте
2. Покупка тура в кредит при отказе банка выдать кредит

## Перечень используемых инструментов с обоснованием выбора
1. Java11 - язык написания автотестов (выбор обоснован учебным практическим опытом)
2. Git, GitHub - инструмент для хранения документов и файлов проекта, кода (позволяет отслеживать изменения, версионирование)
3. JUnit5 - платформа для написания автотестов и их запуска
4. Gradle - система сборки проекта и управления зависимостями (содержит более простые конструкции по сравнению с файлами .xml при использовании Maven)
5. Selenide - инструмент для автоматизации действий в браузере с простым формированием селекторов (при падении тестов образует скриншот)
6. Docker - система контейнеризации приложений, изученная на момент написания дипломной работы.

## Перечень и описание возможных рисков при автоматизации
1. Непокрытие автоматизированной проверкой всех возможных тестовых случаев
2. Возникновение системных ошибок при транзакциях
3. Сложность комплексного взаимосвязанного тестирования системы из нескольких компонентов с учетом минимального уровня компетенции 

## Интервальная оценка с учетом риска в часах
130 часов 

## План сдачи работ
1. до 01.04.2023 - сдача этапа 1 (документа по планированию дипломной работы)
2. до 18.04.2023 - сдача этапа 2 (подготовленных автотестов)
3. до 24.04.2023 - сдача этапа 3 (отчетных документов по итогам автоматизированного тестирования)
4. до 27.04.2023 - сдача этапа 4 (отчетных документов по итогам автоматизации)