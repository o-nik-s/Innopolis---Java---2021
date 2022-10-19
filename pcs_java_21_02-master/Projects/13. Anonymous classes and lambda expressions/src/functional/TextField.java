package functional;

/**
 * 05.11.2021
 * 13. Anonymous classes and lambda expressions
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class TextField {
    private String text = "";

    public void enter(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void replaceStringByMapper(Mapper mapper) {
        this.text = mapper.map(this.text);
    }
}
