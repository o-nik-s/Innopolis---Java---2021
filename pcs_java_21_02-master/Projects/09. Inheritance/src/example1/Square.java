package example1;

/**
 * 29.10.2021
 * 09. Inheritance
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Square {
    private int a;

    public Square(int a) {
        this.a = a;
    }

    public int getArea() {
        return a * a;
    }

    public int getPerimeter() {
        return 4 * a;
    }
}
