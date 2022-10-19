package factroy_method;

/**
 * 27.09.2021
 * 20. Creational Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class ActsProducer implements DocumentsProducer {
    @Override
    public Document create(Information information) {
        FromAndDateTime fromAndDateTime = (FromAndDateTime)information;
        return new Act(fromAndDateTime.getDateTime(), fromAndDateTime.getFrom());
    }
}
