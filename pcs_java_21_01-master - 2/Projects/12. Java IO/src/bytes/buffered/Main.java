package bytes.buffered;

import java.io.*;

/**
 * 12.09.2021
 * 12. Java IO
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        try (InputStream input = new FileInputStream("input.txt");
             BufferedInputStream bufferedInput = new BufferedInputStream(input);){
            bufferedInput.read();
            int i = 0;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
