package examples.lambda.example1;

/**
 * 14.09.2021
 * 14. Anonymous, Lambda, Stream API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
//        TextFieldInputEvent onAfterInput = new TextFieldInputEvent() {
//            @Override
//            public String handle(String text) {
//                return text.toLowerCase();
//            }
//        };

        TextFieldInputEvent onAfterInput = text -> text.toLowerCase();

//        TextFieldEvent onBeforeClear = new TextFieldEvent() {
//            @Override
//            public void handle() {
//                System.out.println("Было что-то введено");
//            }
//        };

        TextFieldEvent onBeforeClear = () -> {
            System.out.println("Так!");
            System.out.println("Было что-то введено");
        };

        TextField textField = new TextField();
        textField.onAfterInput(onAfterInput);
        textField.onBeforeClear(onBeforeClear);

        textField.input("Привет!");
        textField.clear();
        textField.input("Как дела?");
        textField.clear();
        textField.input("Что нового?");
        System.out.println(textField.getText());
        textField.clear();
    }
}
