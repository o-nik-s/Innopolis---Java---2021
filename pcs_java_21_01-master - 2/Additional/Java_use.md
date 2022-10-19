# Рекомендации по Java

01. Упрощение функций с if-ами

Не правильно: 

```java
public static boolean isEven(int number) {
	if (number % 2 == 0) {
		return true;
	} else {
		return false;
	}
}
```

Правильно:

```java
public static boolean isEven(int number) {
	return number % 2 == 0;
}
```

02. Упрощение конструкций с булевскими функциями

Не правильно:

```java
if (isEven(number) == true) {
	// ...
}
```

Правильно:

```java
if (isEven(number)) {
	// ...
}
```

Не правильно:

```java
if (isEven(number) == false) {
	// ...
}
```

Правильно:

```java
if (!isEven(number)) {
	// ...
}
```

03. Использование фигурных скобок:

Не правильно:

```java
if (isEven(number)) sum += number;
```

Правильно:

```java
if (isEven(number)) {
	sum += number;
}
```

04. Скобки

```java
class Program {
	public static void main(String args[]) {
		// ...
		if (isEven(number)) {
			int x = 5;

			while (true) {
				//..
			}
		}
	}
}
```