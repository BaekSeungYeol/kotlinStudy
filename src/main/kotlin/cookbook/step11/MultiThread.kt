package cookbook.step11

import kotlin.concurrent.thread
import kotlin.random.Random

fun main() {
    (0..5).forEach{ n ->
        val sleepTime = Random.nextLong(from = 0, until = 1000L)
        thread {
            Thread.sleep(sleepTime)
            println("${Thread.currentThread().name} for $n after ${sleepTime} ms")
        }.join()
    }
}