package cookbook.step8

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class SmartPhoneTest {
    private val smartPhone: SmartPhone = SmartPhone()

    @Test
    fun `Dialing delegates to internal phone`() {
        assertEquals("Dialing 555-1234...", smartPhone.dial("555-1234"))
    }

    @Test
    fun `Taking picture delegates to internal camera`() {
        assertEquals("Taking picture...", smartPhone.takePicture())
    }

    @Test
    fun `uninitialized value throws exception`() {
        assertThrows<IllegalStateException> { shouldNotBeNull }
    }

    @Test
    fun `initialize value then retrieve it`() {
        shouldNotBeNull = "Hello, World!"
        assertDoesNotThrow { shouldNotBeNull }
        assertEquals("Hello, World!", shouldNotBeNull)
    }

    @Test
    fun `watched variable prints old and new values`() {
        assertEquals(1, watched)
        watched *= 2
        assertEquals(2, watched)
        watched *= 2
        assertEquals(4, watched)
    }

    @Test
    fun `veto values less than zero`() {
        assertAll(
            { assertEquals(0, checked) },
            { checked = 42; assertEquals(42, checked) },
            { checked = -1; assertEquals(42, checked) },
            { checked = 17; assertEquals(17, checked) }
        )
    }
}