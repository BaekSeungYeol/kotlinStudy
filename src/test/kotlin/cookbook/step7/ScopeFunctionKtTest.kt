package cookbook.step7

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ScopeFunctionKtTest {

    @Test
    fun `lat,lng of Boston`() {
        Site(name = "Boston MA",
            latitude = 42.36,
            longitude = -71.06)
            .also { println(it.toString())}
            .run {
                assertThat(latitude).isEqualTo(42.36)
                assertThat(longitude).isEqualTo(-71.06)
            }
    }
}