package observer.documents;

/**
 * 29.09.2021
 * 22. Behavioral Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class TextDocument implements Document {

    private String text;

    public TextDocument(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }
}
