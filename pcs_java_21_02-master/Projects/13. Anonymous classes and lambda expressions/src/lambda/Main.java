package lambda;

/**
 * 05.11.2021
 * 13. Anonymous classes and lambda expressions
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        TextField textField = new TextField();
        textField.enter("Привет!");

        // параметр -> тело реализуемого метода
        Mapper toLowerCaseMapper = string -> string.toLowerCase();

        Mapper toUpperCaseMapper = string -> string.toUpperCase();

        Mapper replaceLettersMapper = string -> {
            string = string.toLowerCase();
            char[] characters = string.toCharArray();
            for (int i = 0; i < characters.length; i++) {
                if (characters[i] == 'п') {
                    characters[i] = 'P';
                }
                if (characters[i] == 'и') {
                    characters[i] = 'i';
                }
                if (characters[i] == 'в') {
                    characters[i] = 'v';
                }
                if (characters[i] == 'а') {
                    characters[i] = '@';
                }
                if (characters[i] == 'с') {
                    characters[i] = '$';
                }
            }
            return new String(characters);
        };

        textField.replaceStringByMapper(replaceLettersMapper);
        System.out.println(textField.getText());
    }
}
