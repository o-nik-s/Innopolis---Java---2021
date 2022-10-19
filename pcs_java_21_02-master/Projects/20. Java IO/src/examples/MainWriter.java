package examples;

import java.io.FileWriter;
import java.io.Writer;

/**
 * 15.11.2021
 * 20. Java IO
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainWriter {
    public static void main(String[] args) {
        try {
            Writer writer = new FileWriter("output2.txt");
            writer.write("Hello!");
            writer.close();
        } catch (Exception e) {
            System.err.println("Что-то не так - " + e.getMessage());
        }
    }
}
