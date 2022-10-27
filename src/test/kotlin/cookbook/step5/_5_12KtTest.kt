package cookbook.step5

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDate

internal class _5_12KtTest {

    @Test
    fun `LocalDate in a range`() {
        val startDate = LocalDate.now()
        val midDate = startDate.plusDays(3)
        val endDate = startDate.plusDays(5)

        val dateRange = startDate..endDate

        assertAll(
            { assertTrue(startDate in dateRange) },
            { assertTrue(midDate in dateRange) },
            { assertTrue(endDate in dateRange) },
            { assertTrue(startDate.minusDays(1) !in dateRange) },
            { assertTrue(endDate.plusDays(1) !in dateRange) },
        )
    }

    // @Test
    // fun `use LocalDate as a progression`() {
    //     val startDate = LocalDate.now()
    //     val endDate = startDate.plusDays(5)
    //
    //     val dateRange: ClosedRange<LocalDate> = startDate..endDate
    //     dateRange.forEachIndexed { index, localDate ->
    //         assertEquals(localDate, startDate.plusDays(index.toLong()))
    //     }
    //
    //
    // }
}