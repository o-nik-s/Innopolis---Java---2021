package nodes;

public class Main {

    public static void main(String[] args) {
	    Node<String> a = new Node<>("Marsel");
	    Node<String> b = new Node<>("Java");
	    Node<String> c = new Node<>("Innopolis");
	    Node<String> d = new Node<>("JVM");
	    Node<String> e = new Node<>("javac");
	    Node<String> f = new Node<>("Lists");

        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        e.setNext(f);

        Node<String> current = a;

        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }
}
