package examples.method_reference;

/**
 * 14.09.2021
 * 14. Anonymous, Lambda, Stream API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class TextField {
    private String text;

    public void input(String text, StringOperation stringOperation) {
        this.text = stringOperation.process(text);
    }

    public String getText() {
        return text;
    }
}
