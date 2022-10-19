package factroy_method;

/**
 * 27.09.2021
 * 20. Creational Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        DocumentsProducer producer = new StatementsProducer();
        DocumentDispatcher dispatcher = new DocumentDispatcher(producer);
        dispatcher.enterDocumentInformation();
    }
}
