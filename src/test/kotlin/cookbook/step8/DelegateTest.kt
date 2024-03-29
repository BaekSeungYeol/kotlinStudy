package cookbook.step8

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class DelegateTest {
    private val strings = listOf("this", "is", "a", "list", "of", "strings")

    init {
        println("Test")
    }

    private lateinit var modifiable : MutableList<Int>

    @BeforeEach
    fun setUp() {
        modifiable = mutableListOf(3,1,4,1,5)
        println("Before: $modifiable")
    }

    @AfterEach
    fun finish() {
        println("After: $modifiable")
    }

    @Test
    fun test1() {

    }
    @Test
    fun test2() {

    }
    @Test
    fun test3() {

    }
}