package examples.lambda.example2;

/**
 * 14.09.2021
 * 14. Anonymous, Lambda, Stream API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        StringUtil stringUtil = new StringUtil();
        System.out.println(stringUtil.fromTwoStrings("Hello", "Bye",
                (x, y) -> x.toLowerCase() + " " + y.toLowerCase()));
    }
}
