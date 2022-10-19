package bytes.files;

import java.io.*;

/**
 * 12.09.2021
 * 12. Java IO
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main3 {
    public static void main(String[] args) {
        try (OutputStream output = new FileOutputStream("output.txt")) {
            output.write("Hello".getBytes());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
