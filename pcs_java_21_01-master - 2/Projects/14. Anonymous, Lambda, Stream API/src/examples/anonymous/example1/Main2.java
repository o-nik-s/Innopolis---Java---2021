package examples.anonymous.example1;

import java.util.ArrayList;
import java.util.List;

/**
 * 14.09.2021
 * 14. Anonymous, Lambda, Stream API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main2 {
    public static void main(String[] args) {

        List<Integer> sizes = new ArrayList<>();

        TextField textField = new TextField() {

            private List<String> history = new ArrayList<>();

            @Override
            public void onAfterInput() {
                this.text = this.text.toLowerCase();
                sizes.add(text.length());
            }

            @Override
            public void onBeforeClear() {
                this.history.add(this.text);
                System.out.println("История - " + history);
            }

            @Override
            public String getText() {
                return "[" + this.text + "]";
            }
        };

        textField.input("Привет!");
        textField.clear();
        textField.input("Как дела?");
        textField.clear();
        textField.input("Что нового?");
        System.out.println(textField.getText());
        textField.clear();
        System.out.println(sizes);

    }
}
