import java.util.Scanner;

/**
 * 30.08.2021
 * 01. Introduction
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();

        int[] maxims = new int[count];

        int currentPair = 0;
        int countOfMaxims = 0;

        while (currentPair < count) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (x < y) {
                System.out.println("X меньше Y");
                maxims[countOfMaxims] = y;
            } else if (x == y){
                System.out.println("X равен Y");
                maxims[countOfMaxims] = y;
            } else {
                System.out.println("X больше Y");
                maxims[countOfMaxims] = x;
            }
            currentPair++;
            countOfMaxims++;
        }

        // while (i < maxims.length) { i++; }
        for (int i = 0; i < maxims.length; i++) {
            System.out.print(maxims[i] + " ");
        }

    }
}
