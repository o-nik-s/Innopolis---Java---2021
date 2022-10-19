package checked;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 09.09.2021
 * 11. Exceptions
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class WordsRepository {
    private String fileName;

    public WordsRepository(String fileName) {
        this.fileName = fileName;
    }

    public String firstWord() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        return reader.readLine();
    }

    public void validateFile(String fileName) throws FileNotFoundException {
        if (!fileName.equals("input.txt")) {
            throw new FileNotFoundException();
        }
    }
}
