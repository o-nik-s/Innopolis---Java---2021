package characters.buffered;

import java.io.*;

/**
 * 12.09.2021
 * 12. Java IO
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        System.out.println(reader.readLine());
        System.out.println(reader.readLine());

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        writer.write("Привет!");
        writer.write("Как дела?");
        writer.flush();
        System.out.println("Конец!");
    }
}
