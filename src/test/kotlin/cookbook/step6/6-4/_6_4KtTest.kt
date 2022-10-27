package cookbook.step6.`6-4`

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDate

internal class _6_4KtTest {

    @Test
    fun `first 10 Fibonacci numbers from sequence`() {
        val fibs = fibonacciSequence()
            .take(10)
            .toList()

        assertEquals(listOf(0,1,1,2,3,5,8,13,21,34), fibs)
    }
}