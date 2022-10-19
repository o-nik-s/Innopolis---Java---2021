package object;

/**
 * 07.09.2021
 * 09. Object, String, Wrappers
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class ObjectsUtils {
    public static boolean isEqual(Object ... args) {
        for (int i = 0; i < args.length - 1; i++) {
            if (!args[i].equals(args[i+1])) {
                return false;
            }
        }

        return true;
    }
}
