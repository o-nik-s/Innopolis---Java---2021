package example2;

/**
 * 29.10.2021
 * 09. Inheritance
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Square extends Rectangle {
    public Square(int a) {
        super(a, a); // вызов конструктора предка
    }
}
