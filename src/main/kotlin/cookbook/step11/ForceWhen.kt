package cookbook.step11

fun printMod3(n: Int) {
    when (n % 3) {
        0 -> println("0")
        1 -> println("1")
        2 -> println("2")
    }
}

val <T> T.exhaustive: T
    get() = this

fun printMod3SingleStatement(n: Int) = when (n % 3) {
    0 -> println("0")
    1 -> println("1")
    2 -> println("2")
    else -> println("we have a problem..")
}.exhaustive