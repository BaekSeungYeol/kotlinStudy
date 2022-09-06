package cookbook.step5

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class _5_7KtTest {

    @Test
    fun chuncked() {
        val range = 0..10

        val chunked = range.chunked(3)
        assertThat(chunked).contains(listOf(0, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8), listOf(9, 10))
        assertThat(range.chunked(3) { it.sum() }).isEqualTo(listOf(3, 12, 21, 19))
        assertThat(range.chunked(3) { it.average() }).isEqualTo(listOf(1.0, 4.0, 7.0, 9.5))
    }

    @Test
    fun windowed() {
        val range = 0..10

        assertThat(range.windowed(3, 3)).contains(listOf(0, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8))
        assertThat(range.windowed(3, 3) { it.average() }).contains(1.0, 4.0, 7.0)

        assertThat(range.windowed(3,1) { it.average()}).contains(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0)
    }
}