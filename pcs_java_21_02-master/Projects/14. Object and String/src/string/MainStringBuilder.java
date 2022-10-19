package string;

/**
 * 07.11.2021
 * 14. Object and String
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainStringBuilder {
    public static void main(String[] args) {
//        String line = "";
//        for (int i = 0; i < 10000; i++) {
//            line += "Hello";
//        }
        StringBuilder builder = new StringBuilder();
        builder.append("Привет").append("Как дела").append("Что нового?");
        String string = builder.toString();
        System.out.println(string);

        StringBuilder line = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            line.append("Hello");
        }
        String result = line.toString();
        System.out.println(line);
    }
}
