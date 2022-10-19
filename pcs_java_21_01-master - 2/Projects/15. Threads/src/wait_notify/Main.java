package wait_notify;

import java.util.Scanner;

/**
 * 16.09.2021
 * 15. Threads
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        Product product = new Product();
        Producer producer = new Producer(product);
        Consumer consumer = new Consumer(product);

        producer.start();
        consumer.start();
    }
}
