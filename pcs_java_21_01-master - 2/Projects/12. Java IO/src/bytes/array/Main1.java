package bytes.array;

import java.io.ByteArrayInputStream;

public class Main1 {

    public static void main(String[] args) {
	    byte[] bytes = {34, 56, 120, ((byte)255)};
        System.out.println((byte)255);


        ByteArrayInputStream input = new ByteArrayInputStream(bytes);
        int byteFromArray = input.read();
        System.out.println(byteFromArray);
        byteFromArray = input.read();
        System.out.println("Available " + input.available());
        System.out.println(byteFromArray);
        byteFromArray = input.read();
        System.out.println(byteFromArray);
        byteFromArray = input.read();
        System.out.println(byteFromArray);
    }
}
