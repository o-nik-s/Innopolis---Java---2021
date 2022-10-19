package wait_notify;

/**
 * 16.09.2021
 * 15. Threads
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Consumer extends Thread {
    private final Product product;

    public Consumer(Product product) {
        super("Consumer");
        this.product = product;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (product) {
                System.out.println("Consumer: Проверяет готовность продукта");
                while (!product.isProduced()) {
                    System.out.println("Consumer: Продукт не готов!!! Ушли в ожидание");
                    try {
                        product.wait();
                    } catch (InterruptedException e) {
                        throw new IllegalArgumentException(e);
                    }
                }
                System.out.println("Consumer: используем продукт");
                product.consume();
                System.out.println("Consumer: оповещаем Producer-а");
                product.notify();
            }

        }
    }
}
