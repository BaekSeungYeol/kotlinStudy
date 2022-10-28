package cookbook.step9

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class BookKtTest {

    companion object {
        @JvmStatic
        private fun fibnumbers() = listOf(
            Arguments.of(1, 1), Arguments.of(2, 1),
            Arguments.of(3, 2), Arguments.of(4, 3),
            Arguments.of(5, 5), Arguments.of(6, 8),
            Arguments.of(7, 13), Arguments.of(8, 21),
            Arguments.of(9, 34), Arguments.of(10, 55),
        )

        @JvmStatic
        private fun fibonacciTestData() = Stream.of(
            FibonacciTestData(number =  1, expected = 1),
            FibonacciTestData(number =  2, expected = 1),
            FibonacciTestData(number =  3, expected = 2),
            FibonacciTestData(number =  4, expected = 3),
            FibonacciTestData(number =  5, expected = 5),
            FibonacciTestData(number =  6, expected = 8),
            FibonacciTestData(number =  7, expected = 13)
        )
    }
    @Test
    fun `Fibonacci numbers (explicit)`() {
        assertAll(
            { assertThat(fibonacci(4)).isEqualTo(3) },
            { assertThat(fibonacci(9)).isEqualTo(34) },
            { assertThat(fibonacci(2000)).isEqualTo(1392522469) },
        )
    }

    @ParameterizedTest(name = "fibonacci({0}) == {1}")
    @MethodSource("fibnumbers")
    fun `first 10 Fibonacci numbers (instance method)`(n: Int, fib: Int) {
        assertThat(fibonacci(n)).isEqualTo(fib)
    }

    @ParameterizedTest
    @CsvSource(
        "1, 1", "2, 1", "3, 2",
        "4, 3", "5, 5", "6, 8", "7, 13", "8, 21",
        "9, 34", "10, 55"
    )
    fun `first 10 Fibonacci numbers (csv)`(n: Int, fib: Int) {
        assertThat(fibonacci(n)).isEqualTo(fib)
    }

    @ParameterizedTest
    @MethodSource("fibonacciTestData")
    fun `check fibonacci using data class`(data: FibonacciTestData) {
        assertThat(fibonacci(data.number)).isEqualTo(data.expected)
    }

}

data class FibonacciTestData(val number: Int, val expected: Int)