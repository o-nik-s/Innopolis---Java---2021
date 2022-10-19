import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final int MB = 1024 * 1024;

    public static void generate(int count, List<byte[]> objects) {
        for (int i = 0; i < count; i++) {
            objects.add(new byte[MB]);
        }
    }

    public static void clear(int count, List<byte[]> objects) {
        for (int i = 0; i < count; i++) {
            objects.remove(objects.size() - 1);
        }
    }

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
        List<byte[]> objects = new ArrayList<>();
        while (true) {
            System.out.println("Mem: " + objects.size());
            System.out.println("1 - generate, 2 - clear, 3 - exit");
            int command = scanner.nextInt();

            if (command == 1) {
                System.out.println("Enter count: ");
                int count = scanner.nextInt();
                generate(count, objects);
            } else if (command == 2) {
                System.out.println("Enter count: ");
                int count = scanner.nextInt();
                clear(count, objects);
            } else if (command == 3) {
                System.exit(0);
            }
        }
    }
}
