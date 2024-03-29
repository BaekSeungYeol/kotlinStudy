package cookbook.step5

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.not
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ImmutableTest {

    @Test
    fun `toList on mutableList makes a readOnly new list`() {
      val mutableNums = mutableListOf(3,1,4,1,5,9)
      val readOnlyNumList: List<Int> = mutableNums.toList()
      assertEquals(mutableNums, readOnlyNumList)
      assertNotSame(mutableNums, readOnlyNumList)
    }

    @Test
    fun `modify mutable list does not change read-only list`() {
        val mutableNums = mutableListOf(3,1,4,1,5,9)
        val readOnly: List<Int> = mutableNums.toList()
        assertEquals(mutableNums, readOnly)

        mutableNums.add(2)
        assertThat(readOnly).doesNotContain(2)

    }

    @Test
    fun `read-only view of a mutable list`() {
        val mutableNums = mutableListOf(3,1,4,1,5,9)
        val readOnlySameList: List<Int> = mutableNums
        assertEquals(mutableNums, readOnlySameList)
        assertSame(mutableNums, readOnlySameList)

        mutableNums.add(2)
        assertEquals(mutableNums, readOnlySameList)
        assertSame(mutableNums, readOnlySameList)
        assertThat(readOnlySameList).contains(2)


    }
}