# Аспектно-ориентированное программирование

* [Проект с аспектами](https://gitlab.com/maxima-it-school/pcs_java_21_01/-/tree/master/Projects/44.%20Spring%20Boot%20Security%20-%20REST)
* [Документация](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#aop)
* [Сравнение Spring AOP и AspectJ](https://www.baeldung.com/spring-aop-vs-aspectj)
* [Pointcut-ы](https://www.baeldung.com/spring-aop-pointcut-tutorial)

* `Advice` - логика, которая реализует сквозную функциональность
* `Joinpoint` - точка, куда мы будем внедрять сквозную функциональность (в нашем случае - это метод).
* `Pointcut` - выражение, которое описывает набор Jointpoint-ов (либо сам набор Jointpoint-ов).
* `Aspect` - модуль, реализующий сквозную функциональность (`Pointcut` + `Advice`)