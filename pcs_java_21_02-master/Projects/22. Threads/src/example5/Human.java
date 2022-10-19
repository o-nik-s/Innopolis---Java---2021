package example5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 21.11.2021
 * 22. Threads
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Human extends Thread {
    private final CreditCard card;
    private final String name;

    private final static Lock LOCK = new ReentrantLock();

    public Human(CreditCard card, String name) {
        this.card = card;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            LOCK.lock();
            if (card.getAmount() > 0) {
                System.out.println(name + " идет покупать...");
                if (card.buy(10)) {
                    System.out.println(name + " купил!");
                } else {
                    System.out.println(name + " говорит: ээээээ....");
                }
            }
            LOCK.unlock();
        }
    }
}
