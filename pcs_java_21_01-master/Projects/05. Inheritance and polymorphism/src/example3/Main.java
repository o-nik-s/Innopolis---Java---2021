package example3;

import figures.*;

/**
 * 02.09.2021
 * 05. Inheritance and polymorphism
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {

    public static void printFigures(Figure ... figures) {
        for (int i = 0; i < figures.length; i++) {
            figures[i].print();
        }
    }

    public static void main(String[] args) {
        Ellipse ellipse = new Ellipse(1, 1, 10, 20);
        Circle circle = new Circle(1, 1, 10);
        Rectangle rectangle = new Rectangle(5, 5, 10, 20);
        Square square = new Square(15, 20, 10);

        printFigures(ellipse, circle, rectangle, square);

//        Figure f1 = ellipse;
//        Figure f2 = circle;
//        Figure f3 = rectangle;
//        Figure f4 = square;
//
//        f1.print();
//        f2.print();
//        f3.print();
//        f4.print();

    }
}
