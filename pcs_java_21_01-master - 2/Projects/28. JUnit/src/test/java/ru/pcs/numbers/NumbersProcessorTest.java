package ru.pcs.numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

/**
 * 13.10.2021
 * 28. JUnit
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("NumberUtil is working")
@ExtendWith(MockitoExtension.class)
class NumbersProcessorTest {
    private NumbersProcessor processor;

    @Mock
    private NumberToBooleanMapper mapper;

    private static final List<Boolean> EXPECTED = Arrays.asList(false, true, true, false, true, false);

    @BeforeEach
    public void setUp() {
        when(mapper.map(0)).thenThrow(IncorrectNumberException.class);
        when(mapper.map(7)).thenReturn(true);
        when(mapper.map(3)).thenReturn(true);
        when(mapper.map(10)).thenReturn(false);
        when(mapper.map(11)).thenReturn(true);
        when(mapper.map(121)).thenReturn(false);
        processor = new NumbersProcessor(mapper);
    }

    @ParameterizedTest(name = "return correct vector for {0}")
    @MethodSource(value = "correctNumbers")
    public void map_on_correct_numbers(List<Integer> numbers) {
        assertEquals(EXPECTED, processor.toBooleanVector(numbers));
    }

    @ParameterizedTest(name = "throws exception for {0}")
    @MethodSource("incorrectNumbers")
    public void map_on_incorrect_numbers(List<Integer> numbers) {
        assertThrows(IncorrectNumberException.class, () -> processor.toBooleanVector(numbers));
    }


    public static Stream<Arguments> correctNumbers() {
        return Stream.of(Arguments.of(Arrays.asList(0, 7, 3, 10, 11, 121)));
    }

    public static Stream<Arguments> incorrectNumbers() {
        return Stream.of(Arguments.of(Collections.singletonList(0)));
    }
}