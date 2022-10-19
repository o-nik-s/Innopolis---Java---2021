package abstract_factory;

/**
 * 27.09.2021
 * 20. Creational Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface DocumentsProducer {
    Act createAct();
    Statement createStatement();
}
