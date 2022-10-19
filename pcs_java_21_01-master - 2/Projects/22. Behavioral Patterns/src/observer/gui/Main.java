package observer.gui;

/**
 * 29.09.2021
 * 22. Behavioral Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        Button button = new Button();

        button.onClick(() -> {
            // concrete observer
            System.exit(0);
        });

        button.click();

        System.out.println("Я тут!");
    }
}
