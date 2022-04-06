package appendix.coroutine

import kotlinx.coroutines.*

fun test() {
    runBlocking {
        launch {
            println("main runBlocking : I'm working in threads ${Thread.currentThread().name}")
        }
        launch(Dispatchers.Default) {
            println("Default : I'm working in thread ${Thread.currentThread().name}")
        }
        launch(newSingleThreadContext("MyOwnThread")) {
            println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name}")
        }
    }
}
fun main() {
    test()
}