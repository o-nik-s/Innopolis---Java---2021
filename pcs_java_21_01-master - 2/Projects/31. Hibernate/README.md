# 6.1

## Hibernate

* `session.save()` - вызывает немедленный insert в базу данных. Обновляет сущность при повторном вызове внутри транзакции.
* `session.persist()` - не гарантирует, что будет вызван немедленный `insert`, при этом, выполняется всегда в рамках транзакций.
Гарантирует актуальное состояние сущности для базы данных.

* `session.load()` - возвращает `proxy` вместо реального объекта, что может ускорить работу в некоторых случах.
Выполняет ленивую инициализацию целевого объекта, по требованию.
* `session.get()` - возвращает сразу целевой объект и мгновенно выполняет `insert`.