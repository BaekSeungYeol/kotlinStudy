package cookbook.step3

import kotlin.random.Random

object MySingleton {
    val myProperty = 3
    fun myFunction() = "Hello"
}

fun main() {
    val x: Nothing? = null
    val x2: String = if(Random.nextBoolean()) "true" else throw Exception("nope")

    for(n in 1..10) {
        val x = when(n%3) {
            0 -> "$n % 3 == 0"
            1 -> "$n % 3 == 1"
            2 -> "$n % 3 == 2"
            else -> throw Exception("Houston, we have a problem ...")
        }
        // assertTrue(x is String)
    }
}
