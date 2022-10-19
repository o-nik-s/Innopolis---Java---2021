package task;

/**
 * 31.10.2021
 * 10. Abstract Classes And Interfaces
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public abstract class DocumentsProcessor {
    private static final int MAX_DOCUMENTS_COUNT = 10;

    protected Document[] documents;
    protected int count;

    public DocumentsProcessor() {
        this.documents = new Document[MAX_DOCUMENTS_COUNT];
        this.count = 0;
    }

    public void addDocument(Document document) {
        // проверяем, не заполнили ли мы весь массив
        if (this.count < MAX_DOCUMENTS_COUNT) {
            this.documents[count] = document;
            count++;
        } else {
            System.err.println("Очередь документов переполнена");
        }
    }

    public abstract void documentsProcess();
}
