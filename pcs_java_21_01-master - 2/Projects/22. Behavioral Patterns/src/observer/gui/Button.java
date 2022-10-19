package observer.gui;

/**
 * 29.09.2021
 * 22. Behavioral Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
// Subject
public class Button {
    private ClickHandler handler;

    public void onClick(ClickHandler handler) {
        this.handler = handler;
    }

    public void click() {
        // notify Observer
        handler.handle();
    }
}
