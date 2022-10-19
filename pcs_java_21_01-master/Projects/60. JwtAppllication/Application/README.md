# JWT + REDIS

1. JWT не требует обращения в базу данных, поскольку вся информация хранится в самом токене.
2. Но что делать, если токен украли, или человек вышел из сессии? Этот токен мы должны добавить в "черный список".
3. При этом, каждый запрос теперь нужно проверять, не прикреплен ли к нему токен из черного списка?
4. Получается, если мы все токены черного списка будем хранить в СУБД - это лишняя нагрузка.
5. Решение REDIS - in memory no sql database. MAP в виде отдельного СУБД, гарантирует очень высокую скорость работы.

## Настройка REDIS

```
/etc/redis/redis.conf

bind 0.0.0.0 ::1
port 6379
```

## Команды REDIS

```
flushall

set user marsel

get user

exists user

exists user1

flushall

HSET user name marsel

HSET user age 27

HGET user name

GET user age

HGETALL user

HVALS user

HKEYS user

SADD passwords qwerty007 qwerty008 qwerty009

SMEMBERS passwords

SCARD passwords

LPUSH marsel 27 

RPUSH marsel 29

LPANGE marsel 0 3
```