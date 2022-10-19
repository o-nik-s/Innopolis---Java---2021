package task;

import intro.User;

/**
 * 31.08.2021
 * 02. OOP. Part 1
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Statistic {
    public int[] calcAges(int maxAge, User[] users) {
        int ages[] = new int[maxAge];

        for (int i = 0; i < users.length; i++) {
            int currentAge = users[i].getAge();
            ages[currentAge]++;
        }

        return ages;
    }
}
