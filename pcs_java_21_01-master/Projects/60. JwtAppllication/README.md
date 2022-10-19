# Docker

## Команды

* `docker build -t [image-name] .` - создает образ на основе папки с `Dockerfile`
* `docker run [image-name]` - запускает контейнер на основе образа
* `docker images` - показывает все образы
* `docker ps` - показывает все контейнеры
* `docker ps -a` - показывает все остановленные контейнеры
* `docker run —name [container-name] [image-name]` - запускает контейнер с заданным именем
* `docker rm [container-id]` - удаляет контейнер по названию
* `docker ps -a -q` - возвращает только id остановленных контейнеров
* `docker rm $(docker ps -qa)` - удаляет все остановленные контейнеры
* `docker run —name [container-name] -d [image-name]` - запускает контейнер в фоне
* `docker stop [container-name]` - остановка контейнера
* `docker run —name [container-name] -d —rm [image-name]` - запускает контейнер в фоне и удаляет после завершения работы
* `docker run —name [container-name] -d —rm -p [host-port:container-port] [image-name]` - пробрасывает порт
* `docker volume ls` - показывает список volumes
* `docker volume create --name node-app-volume` - создание volume
* `docker run —name [container-name] -v [volume-name]:[path-in-container] -d —rm -p [host-port:container-port] [image-name]` - пробрасывает порт
* `winpty docker exec -it [container-name] bash` - открытие консоли контейнера в Windows
* `DOCKER_BUILDKIT=1` - включает режим BUILDKIT-ов для кэширования в том числе.

## Дополнительно 

`\\wsl$\docker-desktop-data\version-pack-data\community\docker\volumes\` - расположение volumes на хост-машине в Windows

### Запуск NodeJS приложения

```
docker run --name node-app-container-1  -v node-app-volume:/usr/applications/nodejs-app/storage -d --rm -p 80:8080 node-app-image
```

### Остановка контейнера

```
docker stop node-app-container-1
```

### Создание volume

docker volume create pgdata

### Скачивание образа

```
docker pull postgres
```

### Запуск PostgreSQL в контейнере

```
docker run --name postgresql-container -p 5433:5432 -e POSTGRES_PASSWORD=qwerty009 -e POSTGRES_DB=app_db -v pgdata:/var/lib/postgresql/data postgres
```

### Запуск Redis в контйенере

```
docker run --name redis-container-1 -v redis-volume:/data -p 6380:6380 -d redis-image
```

### Создание network

```
docker network create bridge-network
```

### Запуск Spring Boot приложения

```
docker run --name application-1 -e SPRING_DATASOURCE_USERNAME=postgres -e SPRING_DATASOURCE_PASSWORD=qwerty009 -e SPRING_DATASOURCE_URL=jdbc:postgresql://172.17.0.2:5432/app_db -e REDIS_HOST=172.17.0.3 -p 80:80 application-image
```