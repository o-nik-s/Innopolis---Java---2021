package anon;

/**
 * 05.11.2021
 * 13. Anonymous classes and lambda expressions
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        TextField textFieldWithMemory = new TextField() {

            private String previousValue;

            @Override
            public void beforeEnter() {
                this.previousValue = text;
            }

            @Override
            public void afterEnter() {
                if (this.text.equals("")) {
                    this.text = previousValue;
                }
            }
        };

        textFieldWithMemory.enter("Привет!");
        textFieldWithMemory.enter("Как дела?");
        textFieldWithMemory.enter("");

        System.out.println(textFieldWithMemory.getText());

        Processor processor = new Processor() {
            @Override
            public int from(String text) {
                return text.length();
            }

            @Override
            public String from(int number) {
                return "Число - " + number;
            }
        };

        System.out.println(processor.from(135));
        System.out.println(processor.from("135"));
    }
}
