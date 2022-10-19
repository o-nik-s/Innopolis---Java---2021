package examples.anonymous.example2;

/**
 * 14.09.2021
 * 14. Anonymous, Lambda, Stream API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        DataConverter converter = new DataConverter() {
            @Override
            public int fromStringToInt(String text) {
                return text.length();
            }

            @Override
            public String fromIntToString(int value) {
                return "Число - " + value;
            }
        };

        System.out.println(converter.fromStringToInt("Приветик!"));
        System.out.println(converter.fromIntToString(123));
        System.out.println(converter.getClass());
    }
}
