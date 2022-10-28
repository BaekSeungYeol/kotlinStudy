package inaction.chapter11

fun buildString(
    builderAction: StringBuilder.() -> Unit
) : String {
    val sb = StringBuilder()
    sb.builderAction()
    return sb.toString()
}

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
}