package characters.files;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Arrays;

/**
 * 12.09.2021
 * 12. Java IO
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Reader reader = new FileReader("input.txt");
        char[] characters = new char[100];
        reader.read(characters);
        System.out.println(new String(characters));
        reader.close();

        Writer writer = new FileWriter("output.txt");
        writer.write("Пока!");
        writer.close();
    }
}
