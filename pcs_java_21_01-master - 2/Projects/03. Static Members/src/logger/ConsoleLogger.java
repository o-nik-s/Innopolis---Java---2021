package logger;

import java.time.LocalDateTime;

/**
 * 02.09.2021
 * 03. Static Members
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class ConsoleLogger {

    // статическое поле, которое будет хранить единственный экземпляр данного класса
    // final на переменной ссылочного типа, означает что нельзя изменить значение
    // ссылки, которая хранится в этой переменной
    private final static ConsoleLogger instance;

    static {
        // создаем единственный экземпляр класса в самом начале работы приложения
        instance = new ConsoleLogger();
    }

    private ConsoleLogger() {

    }


    // метод для получения экземпляра класса
    public static ConsoleLogger getLogger() {
        return instance;
    }

    public void info(String message) {
        System.out.println(LocalDateTime.now() + " " + message);
    }

    public void error(String message) {
        System.err.println(LocalDateTime.now() + " " + message);
    }
}
