package inaction.appendix

data class Foo(val value: Int) {
    val double get() = value * 2
}

fun main() {
    val foo = Foo(3)
    println(foo.double)
}