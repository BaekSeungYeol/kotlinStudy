package cookbook.step13

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

suspend fun retrieve1(url: String) = coroutineScope {
    async(Dispatchers.IO) {
        println("Retrieving data on ${Thread.currentThread().name}")
        delay(100L)
        "asyncResults"
    }.await()
}

suspend fun retrieve2(url: String) =
    withContext(Dispatchers.IO) {
        println("Retrieving data on ${Thread.currentThread().name}")
        delay(100L)
        "withContextResults"
    }

fun main() = runBlocking<Unit> {
    val result1 = retrieve1("www.mysite.com")
    val result2 = retrieve2("www.mysite.com")
    println("printin result on ${Thread.currentThread().name} $result1")
    println("printin result on ${Thread.currentThread().name} $result2")
}