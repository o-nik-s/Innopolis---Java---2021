package figures;

/**
 * 02.09.2021
 * 05. Inheritance and polymorphism
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Rectangle extends Figure {

    protected int a;
    private int b;

    public Rectangle(int x, int y, int a, int b) {
        super(x, y);
        this.a = a;
        this.b = b;
    }

    public void scale(int value) {
        this.a *= value;
        this.b *= value;
    }

    public int getPerimeter() {
        return this.a * 2 + this.b * 2;
    }

    public int getArea() {
        return this.a * this.b;
    }

    public void print() {
        System.out.println("Прямоугольник со сторонами a = " + a + ", b = " + b);
    }
}
