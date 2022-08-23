package cookbook.step3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LateInitDemoTest {
    @Test
    fun `uninitialized lateinit property throws exception`() {
        assertThrows<UninitializedPropertyAccessException> {
            LateInitDemo().name
        }
    }

    @Test
    fun `set the lateinit property and no exception is thrown`() {
        assertDoesNotThrow { LateInitDemo().apply { name = "Dolly" }}
    }
}