package effective.item12

fun Int.factorial(): Int = (1..this).product()

fun Iterable<Int>.product(): Int =
    fold(1) { acc, i -> acc * i }

fun main() {
    // println(10 * 6.factorial())

    val tripleTest = 3 * { println("test") }
    tripleTest

    val tripleTest2 = 3 timeRepeated { println("test") }
    tripleTest2()
}

operator fun Int.times(operator: () -> Unit) {
    repeat(this) { operator() }
}

infix fun Int.timeRepeated(operator: () -> Unit): () -> Unit {
    return { repeat(this) { operator() } }
}