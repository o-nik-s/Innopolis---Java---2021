package format;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * 12.09.2021
 * 12. Java IO
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main2 {
    public static void main(String[] args) throws Exception {
        PrintStream printStream = new PrintStream(new FileOutputStream("output2.txt"));
        printStream.println("Привет");
        printStream.printf("%10d %10s\n", 1234, "Hello!");
        printStream.printf("%10d %10s\n", 1234, "Hello!");
        printStream.printf("%10d %10s\n", 1234, "Hello!");
    }
}
