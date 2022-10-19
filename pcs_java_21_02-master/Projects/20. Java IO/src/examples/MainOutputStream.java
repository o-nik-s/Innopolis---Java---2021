package examples;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MainOutputStream {

    public static void main(String[] args) {
        try {
            OutputStream outputStream = new FileOutputStream("output.txt");
            byte[] bytes = "Hello".getBytes();
            outputStream.write(bytes);
            outputStream.close();
        } catch (IOException e) {
            System.err.println("Проблемы с вводом выводом");
        }
    }
}
