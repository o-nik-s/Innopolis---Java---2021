package example3;

/**
 * 20.11.2021
 * 22. Threads
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class SumThread extends Thread {
    private int from;
    private int to;

    public SumThread(int from, int to) {
        this.from = from;
        this.to = to;
    }
}
