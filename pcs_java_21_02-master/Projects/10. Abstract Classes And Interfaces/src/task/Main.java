package task;

import java.time.LocalDate;

/**
 * 31.10.2021
 * 10. Abstract Classes And Interfaces
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        Act act = new Act("Сдачи работ");
        Act act1 = new Act("Приемки работ");
        Statement statement = new Statement(LocalDate.now(),
                " о приеме на работу", "Марсель", "Иннополис");
        Statement statement1 = new Statement(LocalDate.now().plusDays(2),
                " о прибавке к зарплате", "Марсель", "Иннополис");

        DocumentsPrinter printer = new DocumentsPrinter();
        printer.addDocument(act);
        printer.addDocument(act1);
        printer.addDocument(statement);
        printer.addDocument(statement1);

        printer.documentsProcess();
    }
}
