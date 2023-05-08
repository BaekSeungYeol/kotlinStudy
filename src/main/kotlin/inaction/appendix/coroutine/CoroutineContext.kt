package inaction.appendix.coroutine

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
fun convertQuery(query: String): String {
    return if (query.isNotEmpty() && query.endsWith("/")) {
        query.substring(0, query.length - 1)
    } else {
        query
    }
}
fun main() {
    test()

    println("dasdads".removeSuffix("/"))
    println(convertQuery("ddddd"))
}