package bytes.array;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

/**
 * 12.09.2021
 * 12. Java IO
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main2 {
    public static void main(String[] args) {
        byte[] bytes = {45, 23, 11, 110, 54, 28, 3, 1, 78, 20, 55};
        byte[] bytesFromInput = new byte[30];
        ByteArrayInputStream input = new ByteArrayInputStream(bytes);
        int bytesCount = input.read(bytesFromInput, 3, 5);
        System.out.println("Count - " + bytesCount + " " + Arrays.toString(bytesFromInput));
    }
}
