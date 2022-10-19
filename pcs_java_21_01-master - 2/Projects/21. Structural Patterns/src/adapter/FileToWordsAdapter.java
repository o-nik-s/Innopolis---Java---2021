package adapter;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 27.09.2021
 * 21. Structural Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class FileToWordsAdapter implements WordsSource {

    private static class AdapterWordImpl implements Word {
        private final String value;

        public AdapterWordImpl(String value) {
            this.value = value;
        }

        @Override
        public String value() {
            return value;
        }

        @Override
        public int hashCode() {
            return value.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AdapterWordImpl that = (AdapterWordImpl) o;
            return Objects.equals(value, that.value);
        }

        @Override
        public String toString() {
            return value;
        }
    }

    private BufferedReader reader;

    public FileToWordsAdapter(BufferedReader reader) {
        this.reader = reader;
    }

    public List<Word> getWords() {
      return reader.lines()
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .map(AdapterWordImpl::new)
                .collect(Collectors.toList());
    }
}
