# 1.2

## Наследование

* Принцип ООП, который позволяет организовать иерархию классов таким образом, чтобы потомки копировали
и, возможно, переопределяли содержимое предков.

* `protected` - модификатор доступа, обеспечивает уровень доступа "защищенный", член класса доступен
внутри текущего пакета и для всех потомков.

* Если в классе-потомке определен метод, который в точности повторяет сигнатуру какого-либо метода класса-предка, 
то говорят, что метод "переопределен".

* Восходящее преобразование - возможность присвоить объектной переменной класса-предка ссылку на объект
класса-потомка.

* Если у объектной переменной, которая указывает на объект-потомок, вызвать метод, который был переопределен в потомке,
то будет вызвана реализация потомка.

## Полиморфизм

* Принцип ООП, который позволяет работать с объектами разных типов таким образом, будто они принадлежат одному типу.

## Прочее

* Абстрактный класс - класс, на основе которого нельзя создавать объекты.

* Абстрактный метод - метод без реализации.Если класс содержит хотя бы один абстрактный метод, то класс должен быть помечен как абстрактный.
Если класс-потомок не реализует данный метод, то класс потомок должен быть помечен как абстрактный. 

* Интерфейс - аналог класса, но содержит только абстрактные методы без полей.