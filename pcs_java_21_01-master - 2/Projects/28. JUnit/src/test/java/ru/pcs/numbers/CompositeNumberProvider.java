package ru.pcs.numbers;

import com.sun.org.apache.xpath.internal.Arg;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * 13.10.2021
 * 28. JUnit
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class CompositeNumberProvider implements ArgumentsProvider {

    private final static int NUMBERS_COUNT = 5;
    private static final int HIGH = 100;
    private static final int LOW = 4;
    private final Random random = new Random();

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        List<Arguments> arguments = new ArrayList<>();
        for (int i = 0; i < NUMBERS_COUNT; i++) {
            int fist = LOW + random.nextInt(HIGH);
            int second = LOW + random.nextInt(HIGH);
            int composite = fist * second;
            arguments.add(Arguments.of(composite));
        }
        return arguments.stream();
    }
}
