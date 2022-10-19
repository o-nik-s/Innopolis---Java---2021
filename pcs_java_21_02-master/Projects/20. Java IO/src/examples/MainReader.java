package examples;

import java.io.FileReader;
import java.io.Reader;

/**
 * 15.11.2021
 * 20. Java IO
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainReader {
    public static void main(String[] args) {
        try {
            Reader reader = new FileReader("input.txt");
            int currentCharacter = reader.read();
            while (currentCharacter != -1) {
                System.out.println((char)currentCharacter);
                currentCharacter = reader.read();
            }
        } catch (Exception e) {
            System.err.println("Что-то пошло не так!");
        }

    }
}
