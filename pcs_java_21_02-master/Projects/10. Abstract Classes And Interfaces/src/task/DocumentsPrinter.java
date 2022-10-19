package task;

/**
 * 31.10.2021
 * 10. Abstract Classes And Interfaces
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class DocumentsPrinter extends DocumentsProcessor {
    @Override
    public void documentsProcess() {
        for (int i = 0; i < count; i++) {
            System.out.println(documents[i].getText());
        }
    }
}
