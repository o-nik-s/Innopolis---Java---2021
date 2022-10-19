package synchronization;

/**
 * 16.09.2021
 * 15. Threads
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class CreditCard {
    private int amount;

    public CreditCard(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public synchronized boolean buy(int cost) {
        if (amount >= cost) {
            this.amount -= cost;
            return true;
        } else {
            System.out.println("ДЕНЕГ НЕТ");
            return false;
        }
    }
}
