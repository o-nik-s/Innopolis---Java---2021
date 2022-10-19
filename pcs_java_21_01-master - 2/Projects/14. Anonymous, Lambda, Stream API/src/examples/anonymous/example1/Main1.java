package examples.anonymous.example1;

/**
 * 14.09.2021
 * 14. Anonymous, Lambda, Stream API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main1 {
    public static void main(String[] args) {
        TextField alwaysLowerCase = new TextFieldAlwaysLowerCase();
        alwaysLowerCase.input("Привет как дела что нового");
        System.out.println(alwaysLowerCase.getText());
    }
}
