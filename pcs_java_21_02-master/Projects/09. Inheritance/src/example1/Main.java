package example1;

public class Main {

    public static void main(String[] args) {
	    Rectangle rectangle = new Rectangle(10, 15);
        Square square = new Square(5);

        System.out.println(rectangle.getArea());
        System.out.println(square.getArea());
    }
}
