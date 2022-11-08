package cookbook.step11

import java.io.IOException

@Throws(IOException::class)
fun houstonWeHaveAProblem() {
    throw IOException("File or resource not found")
}

fun main() {
    houstonWeHaveAProblem()
}