package cookbook.step11

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.random.Random

internal class KotlinRandomKtTest {

    @Test
    fun `nextInt with no args gives any Int`() {
        val value = Random.nextInt()
        assertThat(value in Int.MIN_VALUE..Int.MAX_VALUE).isTrue
    }

    @Test
    fun `nextInt with a range gives value between 0 and limit`() {
        val value = Random.nextInt(10)
        assertThat(value in 0..10).isTrue
    }

    @Test
    fun `nextInt with min and max gives value between them`() {
        val value = Random.nextInt(5,10)
        assertThat(value in 5..10).isTrue
    }

    @Test
    fun `Random function produces a seeded generator`() {
        val r1 = Random(12345)
        val nums1 = (1..10).map { r1.nextInt() }
        val r2 = Random(12345)
        val nums2 = (1..10).map { r2.nextInt() }

        println(nums1)
        println(nums2)
        assertThat(nums1).isEqualTo(nums2)
    }
}