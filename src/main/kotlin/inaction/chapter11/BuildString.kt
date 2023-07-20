package inaction.chapter11

import javax.swing.text.html.HTML.Tag.TR

// fun buildString(
//     builderAction: StringBuilder.() -> Unit
// ) : String {
//     val sb = StringBuilder()
//     sb.builderAction()
//     return sb.toString()
// }

fun buildString(builderAction: StringBuilder.() -> Unit) : String =
    StringBuilder().apply(builderAction).toString()


val appendExc1 : StringBuilder.() -> Unit =
    { this.append("!") }

fun main() {
    // val s = buildString {
    //     it.append("Hello, ")
    //     it.append("World!")
    // }

    val s = buildString {
        this.append("Hello, ")
        this.append("World!")
    }
    println(s)

    val stringBuilder = StringBuilder("Hi")
    stringBuilder.appendExc1()
    println(stringBuilder)
    println(buildString(appendExc1))

    val map = mutableMapOf(1 to "one")
    map.apply {
        this[2] = "two"
    }

    with(map) {
        this[3] = "three"
    }
    println(map)
}
