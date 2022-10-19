package example5;

/**
 * 29.10.2021
 * 09. Inheritance
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main2 {
    public static void main(String[] args) {
        Human human;
        Sportsman sportsman = new Sportsman();
        // восходящее преобразование
        human = sportsman;
        human.work();
    }
}
