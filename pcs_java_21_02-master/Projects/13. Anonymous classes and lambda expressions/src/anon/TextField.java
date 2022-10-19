package anon;

/**
 * 05.11.2021
 * 13. Anonymous classes and lambda expressions
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public abstract class TextField {
    protected String text = "";

    public void enter(String text) {
        beforeEnter();
        this.text = text;
        afterEnter();
    }

    public String getText() {
        return text;
    }

    public abstract void beforeEnter();

    public abstract void afterEnter();
}
