package ru.pcs.numbers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 13.10.2021
 * 28. JUnit
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("NumberUtil is working")
class NumberUtilTest {
    private final NumberUtil numberUtil = new NumberUtil();

    @DisplayName("gcd() is working")
    @Nested
    class ForGcd {
        @ParameterizedTest(name = "return {2} on a = {0}, b = {1}")
        @CsvSource(value = {"9,12,3", "18,12,6", "64, 48, 16"})
        public void gcd_on_numbers(int a, int b, int expected) {
            assertThat(numberUtil.gcd(a, b), is(equalTo(expected)));
        }
    }

    @DisplayName(("isPrime() is working"))
    @Nested
    class ForIsPrime {
        @ParameterizedTest(name = "throws exception on {0}")
        @ValueSource(ints = {0, 1})
        public void on_problems_numbers(int number) {
            assertThrows(IncorrectNumberException.class, () -> numberUtil.isPrime(number));
        }

        @ParameterizedTest(name = "return <true> on {0}")
        @ValueSource(ints = {2, 3, 17, 31, 41, 13})
        public void on_primes_numbers(int number) {
            assertTrue(numberUtil.isPrime(number));
        }

        @ParameterizedTest(name = "return <false> on {0}")
        @ValueSource(ints = {121, 169})
        public void on_sqr_numbers(int number) {
            assertFalse(numberUtil.isPrime(number));
        }

        @ParameterizedTest(name = "return <false> on {0}")
        @ArgumentsSource(value = CompositeNumberProvider.class)
        public void on_composite_numbers(int compositeNumber) {
            assertFalse(numberUtil.isPrime(compositeNumber));
        }
    }
}