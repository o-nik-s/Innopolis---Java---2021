package adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 27.09.2021
 * 21. Structural Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class StatisticUtil {
    private WordsSource wordsSource;

    public StatisticUtil(WordsSource wordsSource) {
        this.wordsSource = wordsSource;
    }

    public Map<Word, Integer> dictionary() {
        Map<Word, Integer> result = new HashMap<>();

        List<Word> words = wordsSource.getWords();

        for (Word word : words) {
            if (result.containsKey(word)) {
                result.put(word, result.get(word) + 1);
            } else {
                result.put(word, 1);
            }
        }
        return result;
    }
}
