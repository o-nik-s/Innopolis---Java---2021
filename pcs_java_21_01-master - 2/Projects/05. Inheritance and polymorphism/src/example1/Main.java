package example1;

import figures.Circle;
import figures.Ellipse;
import figures.Rectangle;
import figures.Square;

public class Main {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5, 10, 7, 8);

        rectangle.move(10, 11);
        rectangle.scale(2);

        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimeter());

        Square square = new Square(10, 10, 5);

        System.out.println(square.getArea());
        System.out.println(square.getPerimeter());

        Ellipse ellipse = new Ellipse(10, 15, 20, 35);
        Circle circle = new Circle(5, 6, 10);

        ellipse.move(5, 7);
        circle.move(10, 67);

        rectangle.print();
        square.print();
    }
}
