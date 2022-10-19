package ru.pcs.numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * 13.10.2021
 * 28. JUnit
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class NumbersProcessor {
    private final NumberToBooleanMapper mapper;

    public NumbersProcessor(NumberToBooleanMapper mapper) {
        this.mapper = mapper;
    }

    public List<Boolean> toBooleanVector(List<Integer> numbers) {

        List<Boolean> result = new ArrayList<>();
        for (Integer number : numbers) {
            try {
                result.add(mapper.map(number));
            } catch (IncorrectNumberException e) {
                result.add(false);
            }
        }
        return result;
    }
}
