package example1;

/**
 * 20.11.2021
 * 22. Threads
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class AnotherThread extends Thread {

    public AnotherThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
