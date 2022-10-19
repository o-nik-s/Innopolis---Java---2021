package examples.method_reference;

/**
 * 14.09.2021
 * 14. Anonymous, Lambda, Stream API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class TextProcessor {
    private String prefix;
    private String suffix;

    public TextProcessor(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public String processWithPrefixAndSuffix(String text) {
        return this.prefix + " " + text + " " + this.suffix;
    }

    public static String process(String text) {
        if (text.contains(" ")) {
            return text.replace(" ", "_");
        } else {
            return text;
        }
    }
}
