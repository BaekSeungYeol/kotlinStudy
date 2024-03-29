package inaction.chapter2

import java.util.*

fun isLetter(c : Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'

fun recognize(c : Char) = when(c) {
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
    else -> "I don't know..."
}
fun main() {
    val binaryReps = TreeMap<Char, String>()
    for((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }

    val list = arrayListOf("10", "11", "1001")
    for((index, element) in list.withIndex()) {
        println("$index: $element")
    }

    println(isLetter('q'))
    println(isNotDigit('x'))
    println(recognize('8'))

    println("Kotlin" in "Java".."Scala")
    println("Kotlin" in setOf("Java", "Scala"))
}
