package figures;

/**
 * 02.09.2021
 * 05. Inheritance and polymorphism
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Circle extends Ellipse {
    public Circle(int x, int y, int r) {
        super(x, y, r, r);
    }

    public void print() {
        System.out.println("Круг с радиусом - " + this.r1);
    }
}
