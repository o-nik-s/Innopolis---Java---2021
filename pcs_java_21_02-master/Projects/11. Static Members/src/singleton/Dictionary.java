package singleton;

/**
 * 01.11.2021
 * 11. Static Members
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Dictionary {

    private static final Dictionary instance;

    static {
        instance = new Dictionary();
    }

    private Dictionary() {
        this.words = new String[MAX_WORDS_COUNT];
    }

    public static Dictionary getInstance() {
        return instance;
    }

    private static final int MAX_WORDS_COUNT = 100;

    private String[] words;

    private int count;

    public void add(String word) {
        if (count < MAX_WORDS_COUNT) {
            this.words[count] = word;
            count++;
        } else {
            System.err.println("Переполнение словаря.");
        }
    }

    public String complete(String word) {
        for (int i = 0; i < count; i++) {
            if (this.words[i].startsWith(word)) {
                return this.words[i];
            }
        }
        return "";
    }
}
