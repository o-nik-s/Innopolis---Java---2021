package wait_notify;

/**
 * 16.09.2021
 * 15. Threads
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Producer extends Thread {
    private final Product product;

    public Producer(Product product) {
        super("Producer");
        this.product = product;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (product) {
                System.out.println("Producer: проверяет, не был ли использован продукт");
                while (!product.isConsumed()) {
                    System.out.println("Producer: Продукт не был использован!!! Ушли в ожидание");
                    try {
                        product.wait();
                    } catch (InterruptedException e) {
                        throw new IllegalArgumentException(e);
                    }
                }

                System.out.println("Producer: готовим продукт");
                product.produce();
                System.out.println("Producer: Оповещаем Consumer-а");
                product.notify();
            }
        }
    }
}
