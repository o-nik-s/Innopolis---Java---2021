package examples.lambda.example1;

/**
 * 14.09.2021
 * 14. Anonymous, Lambda, Stream API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class TextField {
    protected String text;

    private TextFieldInputEvent onAfterInput;
    private TextFieldEvent onBeforeClear;

    public void input(String text) {
        this.text = onAfterInput.handle(text);
    }

    public void clear() {
        onBeforeClear.handle();
        this.text = null;
    }

    public void onAfterInput(TextFieldInputEvent onAfterInput) {
        this.onAfterInput = onAfterInput;
    }

    public void onBeforeClear(TextFieldEvent onBeforeClear) {
        this.onBeforeClear = onBeforeClear;
    }

    public String getText() {
        return text;
    }

}
