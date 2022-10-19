package logger;


import com.sun.deploy.uitoolkit.ui.LoggerConsole;
import com.sun.javafx.util.Logging;
import sun.util.logging.LoggingSupport;

import java.util.logging.LogManager;

/**
 * 02.09.2021
 * 03. Static Members
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
//        ConsoleLogger logger = new ConsoleLogger();
//        ConsoleLogger anotherLogger = new ConsoleLogger();

        ConsoleLogger logger = ConsoleLogger.getLogger();
        ConsoleLogger anotherLogger = ConsoleLogger.getLogger();

        logger.info("Программа запущена");
        logger.error("Какая-то ошибка:(");

        anotherLogger.info("Программа все еще работает");
        anotherLogger.error("Теперь опять ошибка");
    }
}
