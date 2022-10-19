package example3;

/**
 * 29.10.2021
 * 09. Inheritance
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        Ellipse ellipse = new Ellipse(3, 4);
        ellipse.paint();

        Circle circle = new Circle(2);
        circle.paint();
        int i = 0;
    }
}
