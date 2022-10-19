package bytes.array;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * 12.09.2021
 * 12. Java IO
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main3 {
    public static void main(String[] args) {
        byte[] bytes = "Hello".getBytes();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            output.write(bytes);
            System.out.println(Arrays.toString(output.toByteArray()));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
