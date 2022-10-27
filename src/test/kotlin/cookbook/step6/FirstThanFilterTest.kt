package cookbook.step6

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class FirstThanFilterTest {


    @Test
    fun findNumbersV1() {
        (100 until 2_000_000).map { it * 2 }
            .filter { it % 3 == 0}
            .first()
    }


    @Test
    fun findNumbersV2() {
        (100 until 2_000_000).map { it * 2 }.first { it % 3== 0 }
    }

    @Test
    fun findNumbersV3() {
        (100 until 2_000_000).asSequence()
            .map { println("doubling $it"); it * 2 }
            .filter { println("filtering $it"); it % 3 == 0 }
            .first()
    }

}