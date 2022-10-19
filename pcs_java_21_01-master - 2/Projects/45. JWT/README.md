# JWT

* JSON Web Token - JSON-объект, закодированный в формате Base64. При этом такой объект содержит информацию о пользователе,
  который отправляет запрос.

[Base64](https://ru.wikipedia.org/wiki/Base64)

* JWT-пример

* Заголовок (Header), содержит служебную информацию, в частности, алгоритм хеширования.

```json
{
  "alg": "HS256",
  "typ": "JWT"
}
```

* Полезная нагрузка (Payload) - содержит важные данные, которые мы хотим направлять от клиента - серверу.

```json
{
  "sub" : 3,
  "email": "sidikov.marsel@gmail.com",
  "state": "CONFIRMED",
  "role": "ADMIN"
}
```

* HMACSHA256 - алгоритм хеширования, позволяет захешировать какую-либо строку с использованием какого-либо ключа.
* Это значит, что вы можете проверить любую строку на предмет того, что из нее можно получить тот же самый хеш с тем же ключом.

* Сигнатура для верификации (Verify signature) - она позволяет серверу доверять данным, которые есть в payload.


```
base64(header) + "." + base64(payload) = 

ewogICJhbGciOiAiSFMyNTYiLAogICJ0eXAiOiAiSldUIgp9.ewogICJzdWIiIDogMywKICAiZW1haWwiOiAic2lkaWtvdi5tYXJzZWxAZ21haWwuY29tIiwKICAic3RhdGUiOiAiQ09ORklSTUVEIiwKICAicm9sZSI6ICJBRE1JTiIKfQ==

HMACSHA256(base64(header) + "." + base64(payload), secretkey) = 

HMACSHA256(base64(header) + "." + base64(payload), secretkey)  = e5f703330da271522c0e7e0061e4643954a1c3a70e567f81651ffbfeb9784a97

Мы получили хеш, который выстроен исходя из header и payload + секертный ключ.

ИТОГО:

ewogICJhbGciOiAiSFMyNTYiLAogICJ0eXAiOiAiSldUIgp9.ewogICJzdWIiIDogMywKICAiZW1haWwiOiAic2lkaWtvdi5tYXJzZWxAZ21haWwuY29tIiwKICAic3RhdGUiOiAiQ09ORklSTUVEIiwKICAicm9sZSI6ICJBRE1JTiIKfQ==.e5f703330da271522c0e7e0061e4643954a1c3a70e567f81651ffbfeb9784a97

```