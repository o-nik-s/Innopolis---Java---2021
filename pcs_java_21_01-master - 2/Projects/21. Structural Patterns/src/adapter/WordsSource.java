package adapter;

import java.util.List;

/**
 * 27.09.2021
 * 21. Structural Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface WordsSource {
    List<Word> getWords();
}
