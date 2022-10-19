package examples.anonymous.example1;

/**
 * 14.09.2021
 * 14. Anonymous, Lambda, Stream API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public abstract class TextField {
    protected String text;

    public void input(String text) {
        this.text = text;
        onAfterInput();
    }

    public void clear() {
        onBeforeClear();
        this.text = null;
    }

    public String getText() {
        return text;
    }

    public abstract void onAfterInput();

    public abstract void onBeforeClear();
}
