# 1.2 

## Обобщения

* Обобщения (Generics) - возможность работать с типами в терминах "неизвестных типов". Мы не заем, какого 
типа переменная `x` и переменная `y`, но мы точно знаем, что они одного и того же типа.

* Обобщения гарантируют безопасность типов при написании кода.

* Стирание типов - особенность работы дженериков. Компилятор проверяет все соответствия типов во время
компиляции приложения, а затем заменяет все параметры на Object.