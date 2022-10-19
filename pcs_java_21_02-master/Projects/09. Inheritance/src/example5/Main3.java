package example5;

/**
 * 29.10.2021
 * 09. Inheritance
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main3 {
    public static void main(String[] args) {
        Human human = new Human();
        Programmer programmer = new Programmer();
        Sportsman sportsman = new Sportsman();
        Student student = new Student();

        Human[] humans = new Human[4];
        humans[0] = human;
        humans[1] = programmer;
        humans[2] = sportsman;
        humans[3] = student;

        for (int i = 0; i < humans.length; i++) {
            humans[i].work();
        }
    }
}
