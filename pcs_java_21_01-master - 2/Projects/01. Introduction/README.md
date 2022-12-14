# 1.1

# Типы данных в Java

* Примитивные типы - переменные данных типов хранят значение непосредственно в себе.

* Ссылочные типы - переменные данных типов хранят в себе ссылку (адрес) на какой-либо объект в оперативной памяти.
Экземпляр ссылочного типа является "указателем".

## Явные и неявные преобразования

* Неявное преобразование - преобразование переменной одного типа к другому типу без явного указания целевого типа.
Такое преобразование возможно между типами, где нет потери данных.

* Явное преобразование - такое преобразование, где явно указывается целевой тип. Оно применяется,
если возможна потеря данных (от большего к меньшему)

## Структура программы

* Структуры управления - линейная структура, условие, цикл. 

* Подпрограммы - именованные блоки кода, которые можно вызывать из любого места программы. 
Разделяются на функции и процедуры.

* Подпрограммы могут иметь одинаковые названия, но разные формальные параметры (разные - совсем), такие подпрограммы
называются перегруженными.

* Функции - подпрограммы, возвращающие конкретное значение в место своего вызова.

* Процедуры - подпрограммы, не возвращающие конкретного значения, но имеющие побочный эффект.

## Передача аргументов в формальные параметры 

* По значению - в формальный параметр копируется значение аргумента, следовательно, создается
копия исходной переменной, и все манипуляции с параметром не приводят к изменению аргумента.

* По ссылке - в формальный параметр копируется ссылка на аргумент (т.е. передается сам аргумент), 
следовательно, любые манипуляции с параметром приводят к изменению аргумента. В Java нет такой возможности.

```c++
void swap(int &a, int &b) 
{
    int temp = a;
    a = b; 
    b = temp;    
}

int main() 
{
    int x = 5;
    int y = 10;

    swap(x, y);
}

```

* В Java все аргументы передаются в формальный параметр по значению. Но, когда аргумент имеет
ссылочный тип, копируется ссылка на значение (т.е. аналогично передаче по ссылке в C/C++).