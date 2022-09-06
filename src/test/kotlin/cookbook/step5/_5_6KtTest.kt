package cookbook.step5

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class _5_6KtTest {

    @Test
    fun `coerceIn given a range`() {
        val range = 3..8
        assertThat(5).isEqualTo(5.coerceIn(range))
        assertThat(range.start).isEqualTo(1.coerceIn(range))
        assertThat(range.endInclusive).isEqualTo(9.coerceIn(range))
    }

    @Test
    fun `coerceIn given min and max`() {
        val min = 2
        val max = 6
        assertThat(5).isEqualTo(5.coerceIn(min,max))
        assertThat(min).isEqualTo(1.coerceIn(min,max))
        assertThat(max).isEqualTo(9.coerceIn(min,max))
    }

}


