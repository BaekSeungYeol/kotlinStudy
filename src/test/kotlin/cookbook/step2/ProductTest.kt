package cookbook.step2

import Product
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.test.assertFalse

import org.assertj.core.api.Assertions.*

internal class ProductTest {

    @Test
    fun `check equivalence`() {
        val p1 = Product("baseball", 10.0)
        val p2 = Product("baseball", 10.0, false)

        assertEquals(p1,p2)
        assertEquals(p1.hashCode(), p2.hashCode())
    }

    @Test
    fun `create set to check equals and hashcode`() {
        val p1 = Product("baseball", 10.0)
        val p2 = Product(price = 10.0, onSale = false, name = "baseball")

        val products = setOf(p1,p2)
        assertEquals(1, products.size)
    }

    @Test
    fun `change price using copy`() {
        val p1 = Product("baseball", 10.0)
        val p2 = p1.copy(price = 12.0)
        assertAll(
            { assertEquals("baseball", p2.name) },
            { assertThat(p2.price).isEqualTo(12.0) },
            { assertFalse { p2.onSale }}
        )
    }
}