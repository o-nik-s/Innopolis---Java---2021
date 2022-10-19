package synchronization;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * 16.09.2021
 * 15. Threads
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Human extends Thread {
    private final CreditCard creditCard;

    private String name;

    public Human(CreditCard creditCard, String name) {
        this.creditCard = creditCard;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (creditCard) {
                if (creditCard.getAmount() > 0) {
                    System.out.println(name + " идет покупать...");
                    if (creditCard.buy(10)) {
                        System.out.println(name + " купил!");
                    } else {
                        System.out.println(name + "говорит: ээээээээ");
                    }
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new IllegalArgumentException(e);
                }
            }

        }
    }
}
