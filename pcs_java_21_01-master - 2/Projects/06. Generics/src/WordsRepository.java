import java.util.Scanner;

/**
 * 03.09.2021
 * 06. Generics
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class WordsRepository {

    private String words[] = new String[]{"Hello", "Bye", "Marsel", "Java", "Zet"};

    public Nullable<String> findWordByCharacter(char character) {
//        if (character == 'x') {
//            return Nullable.of(new Scanner(System.in));
//        }

        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(character) != -1) {
                return Nullable.of(words[i]);
            }
        }

        return Nullable.empty();
    }
}
