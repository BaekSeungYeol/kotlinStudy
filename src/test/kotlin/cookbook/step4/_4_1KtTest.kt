package cookbook.step4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class _4_1KtTest {
    @Test
    fun `sum using fold`() {
        val numbers = intArrayOf(3, 1, 4, 1, 5, 9)
        assertEquals(numbers.sum(), sumWithTrace(*numbers))
    }

    @Test
    fun `sum using reduce`() {
        val numbers = intArrayOf(3, 1, 4, 1, 5, 9)
        assertAll(
            { assertEquals(numbers.sum(), sumReduce(*numbers)) },
            { assertThrows<UnsupportedOperationException>{ sumReduce() } }
        )
    }
}