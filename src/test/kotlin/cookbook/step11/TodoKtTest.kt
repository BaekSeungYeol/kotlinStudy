package cookbook.step11

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class TodoKtTest {

    @Test
    fun `todo test`() {
        val exception = assertThrows<NotImplementedError> {
            TODO("seriously, finish this")
        }

        assertThat("An operation is not implemented: seriously, finish this").isEqualTo(exception.message)
    }
}