package inaction.chapter3

import inaction.chapter3.lastChar as last

var opCount = 0
const val UNIX_LINE_SEPARATOR ="\n"

fun performOperation() {
    opCount++
}
fun reportOperationCount() {
    println("Operation performed $opCount times")
}

fun String.lastChar() : Char =
    get(length - 1)

fun main() {
    val c = "Kotlin".last()
}
