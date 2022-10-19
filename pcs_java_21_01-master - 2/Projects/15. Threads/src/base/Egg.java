package base;

/**
 * 16.09.2021
 * 15. Threads
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Egg extends Thread {

    public Egg() {
        super("Egg");
    }

    @Override
    public void run() {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            throw new IllegalArgumentException(e);
        }
        for (int i = 0; i < 100_000; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
