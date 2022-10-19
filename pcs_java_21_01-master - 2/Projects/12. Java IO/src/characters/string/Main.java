package characters.string;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * 12.09.2021
 * 12. Java IO
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {

        String hello = "HelloЫ";
        Reader reader = new StringReader(hello);
        System.out.println((char)reader.read());
        System.out.println((char)reader.read());
        System.out.println((char)reader.read());
        System.out.println((char)reader.read());
        System.out.println((char)reader.read());
        System.out.println((char)reader.read());
        System.out.println(reader.read());

        Writer writer = new StringWriter();
        writer.write('ы');
        writer.write('h');
        String message = writer.toString();
        System.out.println(message);
    }
}
