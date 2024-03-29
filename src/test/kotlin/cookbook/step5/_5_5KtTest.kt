package cookbook.step5

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class _5_5KtTest {
    private val overthruster = Product("Oscillation Overthruster", 1_000_000.0)
    private val fluxcapacitor = Product("Flux Capacitor", 299_999.95, onSale = true)
    private val tpsReportCoverSheet = Product("TPS Report Cover Sheet", 0.25)


    @Test
    fun productsOnSale() {
        val products = listOf(overthruster, fluxcapacitor, tpsReportCoverSheet)
        assertAll("On sale products",
            { assertEquals("Flux Capacitor", onSaleProducts_ifEmptyCollection(products)) },
            { assertEquals("Flux Capacitor", onSaleProducts_ifEmptyString(products)) }
            )
    }

    @Test
    fun productsNotOnSale() {
        val products = listOf(overthruster, fluxcapacitor, tpsReportCoverSheet)
        assertAll("On sale products",
            { assertEquals("Flux Capacitor", onSaleProducts_ifEmptyCollection(products)) },
            { assertEquals("Flux Capacitor", onSaleProducts_ifEmptyString(products)) }
        )
    }

}