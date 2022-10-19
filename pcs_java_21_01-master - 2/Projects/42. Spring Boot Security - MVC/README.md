# 7.6

## Spring Boot Security MVC

* Что есть "ваш пользователь"?
* Как получить вашего пользователя, зная только его nickname?

## PasswordEncoder

* Пароли нельзя хранить в открытом виде.
* Хеширования пароля - видоизменение пароля таким образом, чтобы нельзя было понять, что это за пароль.
* Но при этом, можно было бы определить, получен ли этот хеш из пароля, который ввел пользователь для входа.

### BCrypt

```
Сохранения пароля:

qwerty007

$[2a]$[10]$[qDBP71BL9YG4XVqD77tuju][dsmyBj2.x/HDapj71D9hHnFZmOKi50a]

-> enter password -> salt generate -> hash(password + salt) = hash

-> qwerty007 -> qDBP71BL9YG4XVqD77tuju -> hash(qwerty007 + qDBP71BL9YG4XVqD77tuju) = dsmyBj2.x/HDapj71D9hHnFZmOKi50a

result -> $2a$10$qDBP71BL9YG4XVqD77tujudsmyBj2.x/HDapj71D9hHnFZmOKi50a

Валидация пароля:

1. пользователь вводит пароль -> qwerty007
2. в базе данных находим пользователя под нужным именем и берем его хеш-пароля

Задача, сравнить qwerty007 и $2a$10$qDBP71BL9YG4XVqD77tujudsmyBj2.x/HDapj71D9hHnFZmOKi50a

Берем соль из сохранненного пароля qDBP71BL9YG4XVqD77tuju и хешируем ее с qwerty007, если получили тот же хеш, что и в базе
то пароль был введен верно.
```