package wait_notify;

/**
 * 16.09.2021
 * 15. Threads
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Product {
    private boolean isReady;

    public boolean isConsumed() {
        return !isReady;
    }

    public boolean isProduced() {
        return isReady;
    }

    public void consume() {
        this.isReady = false;
    }

    public void produce() {
        this.isReady = true;
    }
}
