package examples;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 15.11.2021
 * 20. Java IO
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainInputStream {
    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream("input.txt");
            // 0 - 255
            // -1
            int currentByte = inputStream.read();

            while (currentByte != -1) {
                System.out.print((char)currentByte + " ");
                currentByte = inputStream.read();
            }

            inputStream.close();
        } catch (Exception e) {
            System.err.println("Проблемы - " + e.getMessage());
        }
    }
}
