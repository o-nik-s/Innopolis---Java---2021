/**
 * 27.10.2021
 * 08. OOP
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main3 {
    public static void main(String[] args) {
        Human[] humans = new Human[3];

        for (int i = 0; i < humans.length; i++) {
            humans[i] = new Human();
            humans[i].setName("User" + i);
            humans[i].setAge(24);
        }

        System.out.println(humans[1].getName());
    }
}
