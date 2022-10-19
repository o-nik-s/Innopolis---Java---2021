package bytes.buffered;

import java.io.*;

/**
 * 12.09.2021
 * 12. Java IO
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main2 {
    public static void main(String[] args) {
        try (OutputStream output = new FileOutputStream("output.txt");
             BufferedOutputStream bufferedOutput = new BufferedOutputStream(output)) {
            bufferedOutput.write(127);
            bufferedOutput.write(139);
            bufferedOutput.write(140);
            bufferedOutput.flush();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
