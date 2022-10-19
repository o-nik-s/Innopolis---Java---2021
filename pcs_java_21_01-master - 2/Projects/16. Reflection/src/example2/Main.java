package example2;

import example2.framework.DocumentsFramework;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * 22.09.2021
 * 16. Reflection
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        DocumentsFramework framework = new DocumentsFramework();
        Statement statement = framework.generate(Statement.class, "Сидиков Марсель",
                LocalDate.of(1994, 2, 2));
        Act act = framework.generate(Act.class, LocalDate.now(), "Сверка", "От налоговой!");
        Letter letter = framework.generate(Letter.class, LocalTime.now());
        System.out.println(statement);
        System.out.println(act);
        System.out.println(letter);
    }
}
