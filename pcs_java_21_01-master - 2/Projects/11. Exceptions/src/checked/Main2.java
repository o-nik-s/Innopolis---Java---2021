package checked;

import java.io.IOException;

/**
 * 09.09.2021
 * 11. Exceptions
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        WordsRepository wordsRepository = new WordsRepository("input.txt");
        wordsRepository.validateFile("input.txt");
        System.out.println(wordsRepository.firstWord());

    }
}
