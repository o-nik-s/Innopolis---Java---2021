package observer.documents;

/**
 * 29.09.2021
 * 22. Behavioral Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        DocumentsDispatcher dispatcher = new DocumentsDispatcher();

        dispatcher.addHandler(document -> System.out.println("Документ " + document.getText() + " отправлен на почту"));

        dispatcher.addHandler(document -> System.out.println("Документ " + document.getText() + " отправлен в отдел по контролю качества"));

        dispatcher.addHandler(document -> System.out.println("Документ " + document.getText() + " отправлен в бухгалтерию"));

        dispatcher.dispatchDocument(new TextDocument("Справка"));
    }
}
