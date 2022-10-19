package ru.pcs;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 28.11.2021
 * 25. JUnit
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@DisplayName(value = "NumbersUtil is working when")
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
class NumbersUtilTest {

    // то, что мы будем тестировать
    private final NumbersUtil numbersUtil = new NumbersUtil();

    @Nested
    @DisplayName("isPrime() is working")
    public class ForIsPrime {
        @ParameterizedTest(name = "return <true> on {0}")
        @ValueSource(ints = {2, 3, 71, 113})
        public void on_prime_numbers_return_true(int number) {
            assertTrue(numbersUtil.isPrime(number));
        }

        @ParameterizedTest(name = "return <false> on {0}")
        @ValueSource(ints = {22, 33, 72, 114})
        public void on_not_prime_numbers_return_false(int number) {
            assertFalse(numbersUtil.isPrime(number));
        }

        @ParameterizedTest(name = "return <false> on {0}")
        @ValueSource(ints = {121, 169})
        public void on_sqr_numbers_return_false(int sqrNumber) {
            assertFalse(numbersUtil.isPrime(sqrNumber));
        }

        @ParameterizedTest(name = "throws exception on {0}")
        @ValueSource(ints = {0, 1})
        public void bad_numbers_throws_exception(int badNumber) {
            assertThrows(IllegalArgumentException.class, () -> numbersUtil.isPrime(badNumber));
        }
    }

    @Nested
    @DisplayName("sum() is working")
    public class ForSum {
        @ParameterizedTest(name = "return {2} on {0} + {1}")
        @CsvSource(value = {"5, 10, 15", "4, 2, 6", "11, -2, 9"})
        public void return_correct_sum(int a, int b, int result) {
            assertEquals(result, numbersUtil.sum(a, b));
        }
    }
}