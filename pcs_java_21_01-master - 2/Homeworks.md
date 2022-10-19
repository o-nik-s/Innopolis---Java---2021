# Домашние задания

## Homework01 - TV

```
Смоделировать предметную область "Телевизор"

Телевизор
    - модель
    - список каналов
Канал
    - Название
    - список передач
Передача
    - Название
Пульт
    - Телевизор
``` 

* Пример использования разработанных моделей

```java
class Program {
    public static void main(String[] args) {
        TV tv = new TV("Samsung");
        Channel channel = new Channel("Первый");
        Program p1 = new Program("Давай поженимся");
        Program p2 = new Program("Малахов+");
        Program p3 = new Program("Пусть говорят");
        
        Controller controller = new Controller(tv);
        
        tv.addChannel(channel);
        channel.addProgram(p1);
        channel.addProgram(p2);
        channel.addProgram(p3);
        
        controller.on(1); // случайную программу из Первого канала
    }
}
```

## Homework02 - ArrayList

```
Самостоятельно реализовать методы get/add/iterator для класса ArrayList.

Список должен иметь возможность "увеличивать" свой объем при переполнении.

PS. Учтите, что список может содержать как 1, так и 100500 элементов, нет необходимости занимать лишнюю память под пустые ячейки.

PS. PS. не подглядывать никуда :)
```

## Homework00 - Git

```
Залить предыдущие домашние задания в Git-репозиторий. Использовать подход Gitflow
```

## Homework03 - Collections

```
На вход подается строка произвольной длины. Необходимо вывести буквы, встречающиеся в этой строке и их количество.

Пример для строки "aaabbcc`

a - 3
b - 2
c - 2

Реализовать с использованием HashMap
```

## Homework04 - Exceptions

```
Реализовать интерфейс UsersService и соответствующие классы исключений.
Архитектура классов на усмотрение разработчика.

public interface UsersService {
    /**
     * Сохраняет пользователя с указанными данными в списке (ArrayList, LinkedList)
     * @param email емейл пользователя (должен содержать символ @)
     * @param password пароль пользователя (должен состоять из букв и цифр, длина > 7)
     * @throws BadEmailException - если неверный формат почты
     * @throws BadPasswordException - если формат пароля неверный
     */
    void signUp(String email, String password);

    /**
     * Аутентифицирует пользователя
     * @param email емейл пользователя
     * @param password пароль пользователя
     * @throws UserNotFoundException - если пользователь не был найден
     */
    void signIn(String email, String password);
}
```