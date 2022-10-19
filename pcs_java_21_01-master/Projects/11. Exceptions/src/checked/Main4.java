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
public class Main4 {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("input.txt"));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
        String word = null;
        try {
            word = bufferedReader.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        System.out.println(word);
    }
}
