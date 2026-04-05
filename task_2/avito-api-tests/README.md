# API тесты Авито

Автотесты для проверки API микросервиса объявлений.

## Что тестируется
- POST `/api/1/item` — создание объявления
- GET `/api/1/item/{id}` — получение объявления по ID
- GET `/api/1/{sellerId}/item` — получение объявлений по sellerId
- GET `/api/1/statistic/{itemId}` — получение статистики

## Запуск тестов

### Требования
- Java 17+
- Maven
- scope на windows (можно без него)

### Команда
```bash
mvn clean test
```
Можно через Maven запустить в Lifecycle - test,
можно запустить класс AvitoApiTest


### Allure отчет:
1) установка allure через Scope
#### (на windows)
1) scoop install allure 
#### (macOS)
1) brew install allure
#### (linux)
1) sudo apt-add-repository ppa:qameta/allure
2) sudo apt-get update
3) sudo apt-get install allure

### Генерация отчета (Allure)
- allure serve target/allure-results  (может потребоваться полный путь)

### Файлы:
#### AvitoApiTest - автотесты
#### TESTCASES.md - тест-кейсы
#### BUGS.md - найденные баги
#### pom.xml - зависимости
