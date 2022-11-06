package cookbook.step11

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ReplaceKtTest {

    @Test
    fun `demonstrate replace with a string vs regex`() {
        assertAll(
            { assertThat("one*two*").isEqualTo("one.two.".replace(".", "*"))},
            { assertThat("********").isEqualTo("one.two.".replace(".".toRegex(), "*"))},
        )
    }

    @Test
    fun toBinaryStringAndBack() {
        val str = 42.toString(radix = 2)
        assertThat(str).isEqualTo("101010")

        val num = "101010".toInt(radix = 2)
        assertThat(num).isEqualTo(42)
    }
}