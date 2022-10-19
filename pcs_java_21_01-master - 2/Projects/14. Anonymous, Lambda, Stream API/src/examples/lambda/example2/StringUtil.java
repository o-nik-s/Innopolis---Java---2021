package examples.lambda.example2;

/**
 * 14.09.2021
 * 14. Anonymous, Lambda, Stream API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class StringUtil {
    private int minLength;

    private TwoStringsOperation defaultOperation = (a, b) -> {
      if (a.length() > this.minLength && b.length() > this.minLength) {
          return a + " " + b;
      } else return a + b;
    };

    public String fromTwoStrings(String a, String b, TwoStringsOperation operation) {
        if (operation == null) {
            operation = defaultOperation;
        }
        return operation.process(a, b);
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }
}
