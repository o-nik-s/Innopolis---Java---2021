package bytes.files;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 12.09.2021
 * 12. Java IO
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main1 {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("input.txt");
            int bytesCount = fileInputStream.available();
            System.out.println(bytesCount);
            int byteFromFile = fileInputStream.read();
            while (byteFromFile != -1) {
                System.out.print((char)byteFromFile);
                byteFromFile = fileInputStream.read();
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
