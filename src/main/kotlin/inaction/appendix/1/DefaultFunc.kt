package inaction.appendix.`1`

import inaction.chapter10.foo

inline fun <E> Iterable<E>.strings(transform: (E) -> String = { it.toString() }) = map { transform(it) }

fun main() {
    val defaultStrings = listOf(1, 2, 3).strings()
    val customStrings = listOf(1, 2, 3).strings { "($it)" }
    println(defaultStrings)
    println(customStrings)

}

enum class Foo {
    BAR {
        inner class Baz
        // class Baz2
    }
}

class Test {

    private fun foo(): String {
        return "Test"
    }

    fun numToString(param: (a: Int) -> String): () -> String {
        return this::foo
    }
}