package factroy_method;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * 27.09.2021
 * 20. Creational Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class DocumentDispatcher {
    private DocumentsProducer documentsProducer;

    public DocumentDispatcher(DocumentsProducer documentsProducer) {
        this.documentsProducer = documentsProducer;
    }

    public void enterDocumentInformation() {
        Scanner scanner = new Scanner(System.in);
        String from = scanner.nextLine();
        LocalDateTime dateTime = LocalDateTime.now();

        Information information = new FromAndDateTime(from, dateTime);

        Document document = documentsProducer.create(information);

        dispatch(document);
    }

    private void dispatch(Document document) {
        System.out.println(document);
    }
}
