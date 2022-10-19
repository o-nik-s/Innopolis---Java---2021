package example2;

public class Main {

    public static void main(String[] args) {
	    Rectangle rectangle = new Rectangle(10, 15);
        Square square = new Square(5);

        System.out.println(rectangle.getArea());
        System.out.println(square.getArea());
        System.out.println(rectangle.getPerimeter());
        System.out.println(square.getPerimeter());
    }
}
