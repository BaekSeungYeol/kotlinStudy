package inaction.appendix

fun interface IntPredicate {
    fun accept(i: Int): Boolean
}

fun main() {

    val isEven = IntPredicate { it%2 == 0}

    println(isEven.accept(2))
}