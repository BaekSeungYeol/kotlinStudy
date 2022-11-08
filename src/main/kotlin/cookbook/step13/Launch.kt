package cookbook.step13

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    println("Before creating coroutine")
    runBlocking {
        println("Before launch")
        launch {
            print("Hello, ")
            delay(1000L)
            println("World!")
        }
        println("After launch")
    }
    println("After creating coroutine")
}