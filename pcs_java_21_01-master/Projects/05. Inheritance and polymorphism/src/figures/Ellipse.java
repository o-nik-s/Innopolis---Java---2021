package figures;

/**
 * 02.09.2021
 * 05. Inheritance and polymorphism
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Ellipse extends Figure {

    protected int r1;
    protected int r2;

    public Ellipse(int x, int y, int r1, int r2) {
        super(x, y);
        this.r1 = r1;
        this.r2 = r2;
    }

    public void scale(int value) {
        this.r1 *= value;
        this.r2 *= value;
    }

    public int getPerimeter() {
        return (int)(4 * (((Math.PI * r1 * r2) + (r1 - r2)) / (r1 + r2)));
    }

    public int getArea() {
        return (int)(2 * Math.PI * r1 * r2);
    }

    public void print() {
        System.out.println("Эллипс со радиусами r1 = " + r1 + ", r2 = " + r2);
    }
}
