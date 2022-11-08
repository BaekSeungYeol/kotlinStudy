package cookbook.step13

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    println("Before creating coroutine")
    runBlocking {
        print("Hello, ")
        delay(3000L)
        println("World! ")
    }
    println("After creating coroutine")
}