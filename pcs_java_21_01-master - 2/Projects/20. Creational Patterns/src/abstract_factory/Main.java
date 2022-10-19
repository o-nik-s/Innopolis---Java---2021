package abstract_factory;


/**
 * 27.09.2021
 * 20. Creational Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        DocumentsProducer producer = new DocumentsProducerWithIdImpl();
        Statement statement = producer.createStatement();
        Act act = producer.createAct();

        System.out.println(statement.getDescription());
        System.out.println(act.getDescription());
    }
}
