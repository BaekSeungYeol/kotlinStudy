package cookbook.step2

import Product
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class OrderItemTest {

    @Test
    fun `data copy function is shallow`() {
        val item1 = OrderItem(Product("baseball", 10.0), 5)
        val item2 = item1.copy()

        assertAll(
            { assertThat(item1).isEqualTo(item2) },
            { assertThat(item1).isNotSameAs(item2) },
            { assertThat(item1.product).isEqualTo(item2.product) },
            { assertThat(item1.product).isSameAs(item2.product) },
        )
    }
}