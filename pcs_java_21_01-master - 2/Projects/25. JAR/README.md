# 4.1

## JAR

* `javac -d target/ src/java/ru/pcs/*/*.java` - компиляция в папку `target` всех java-файлов.

* `jar xf jcommander-1.78.jar com` - распаковка содержимого архива (папки `com`).

* `jar -cvmf ../src/manifest.txt app.jar .` - сборка архива с собственным файлом MANIFEST.

* `jar tf app.jar` - показать содержимое архива.

* `java -jar app.jar --files=Hello.txt,Bye.txt` - запуск архива с параметрами.