package inaction.chapter9

fun <T : Comparable<T>> max(first: T, second: T): T {
    return if (first > second) first else second
}

fun <T> ensureTrailingPeriod(seq: T) where T : CharSequence, T : Appendable {
    if (!seq.endsWith('.')) {
        seq.append('.')
    }
}

fun printSum(c: Collection<*>) {
    val intList = c as? List<Int> ?: throw IllegalArgumentException("List is expected")
}

fun printSum2(c: Collection<Int>) {
    if(c is List<Int>) {
        println(c.sum())
    }
}

class Processor<T : Any> {
    fun process(value: T) {
        // value?.hashCode()
        value.hashCode()
    }
}

inline fun <reified T> isA(value: Any) = value is T

fun main() {
    println(max("kotlin", "java"))
    // println(max("kotlin", 42))


    println(isA<String>("abc"))
    println(isA<String>(123))

    val items = listOf("one", 2, "three")
    println(items.filterIsInstance<String>())

}
