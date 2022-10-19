package object;

import java.util.Random;
import java.util.Scanner;

public class MainToString {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Human human = new Human(27, true);
        Random random1 = null;

        System.out.println(scanner);
        System.out.println(random);
        System.out.println(human);
        System.out.println(random1);
    }
}
