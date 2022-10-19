package format;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 12.09.2021
 * 12. Java IO
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new FileInputStream("input.txt"));
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        double z = scanner.nextDouble();
        boolean a = scanner.nextBoolean();
        System.out.println(x + " " + y + " " + z + " " + a);
    }
}
