package chapter3

infix fun Any.to(other: Any) = Pair(this,other)

fun main() {

    val (number,name) = 1 to "one"

    println("12.345-6.A".split(".", "-"))

}