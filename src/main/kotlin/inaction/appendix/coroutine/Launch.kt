package inaction.appendix.coroutine

import kotlinx.coroutines.*
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit

/**
 * p.592 Kotlin in Action
 * kotlinx.coroutines.CoroutineScope.launch
 */

fun now() = ZonedDateTime.now().toLocalTime().truncatedTo(ChronoUnit.MILLIS)

fun log(msg: String) = println("${now()} : ${Thread.currentThread()} : ${msg}")

fun runBlockingExample() {
    runBlocking {
        launch {
            log("coroutine started.")
        }
    }
}
fun main() {
    log("main() started.")
    runBlockingExample()
    log("runBlockingExample() executed")
    Thread.sleep(5000L)
    log("main() terminated")
}
