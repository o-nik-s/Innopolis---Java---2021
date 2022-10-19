package observer.documents;

import java.util.ArrayList;
import java.util.List;

/**
 * 29.09.2021
 * 22. Behavioral Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
// Subject
public class DocumentsDispatcher {
    private List<DocumentsHandler> handlers;

    public DocumentsDispatcher() {
        this.handlers = new ArrayList<>();
    }

    public void addHandler(DocumentsHandler handler) {
        this.handlers.add(handler);
    }

    public void dispatchDocument(Document document) {
        for (DocumentsHandler handler : handlers) {
            handler.handle(document);
        }
    }
}
