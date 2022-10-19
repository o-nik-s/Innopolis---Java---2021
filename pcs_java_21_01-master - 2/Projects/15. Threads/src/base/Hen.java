package base;

/**
 * 16.09.2021
 * 15. Threads
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Hen extends Thread {

    public Hen() {
        super("Hen");
    }

    @Override
    public void run() {
        for (int i = 0; i < 100_000; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
