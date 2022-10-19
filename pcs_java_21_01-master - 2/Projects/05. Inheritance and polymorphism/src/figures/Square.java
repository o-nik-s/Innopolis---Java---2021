package figures;

/**
 * 02.09.2021
 * 05. Inheritance and polymorphism
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Square extends Rectangle {
    public Square(int x, int y, int a) {
        super(x, y, a, a);
    }

    public void print() {
        System.out.println("Квадрат со стороной - " + this.a);
    }
}
