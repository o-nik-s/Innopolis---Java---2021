package base;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        Thread egg = new Egg();
        Thread hen = new Hen();

        egg.start();
        hen.start();

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            throw new IllegalArgumentException(e);
        }

        for (int i = 0; i < 100_000; i++) {
            System.out.println("Tirex");
        }

    }
}
