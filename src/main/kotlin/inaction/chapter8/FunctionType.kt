package inaction.chapter8

val sum: (Int, Int) -> Int = { x, y -> x + y }
val action: () -> Unit = { println(42) }
val canReturnNull: (Int, Int) -> Int? = { x, y -> null }
var funOrNull: ((Int, Int) -> Int)? = null

fun performRequest(
    url: String,
    callback: (code: Int, content: String) -> Unit
) {
}

fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("The result is $result")
}

fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()
    for(a in this) {
        if(predicate(a)) {
            sb.append(a)
        }
    }
    return sb.toString()
}

fun processTheAnswer(f: (Int) -> Int) {
    println(f(42))
}

fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
    transform: ((T) -> String)? = null
) : String {
    val result = StringBuilder(prefix)

    for((index,element) in this.withIndex()) {
        if(index > 0) result.append(separator)
        result.append(transform?.invoke(element) ?: element.toString())
    }
    result.append(postfix)
    return result.toString()
}
fun main() {
    val url = "http://kotl.in"
    performRequest(url) { code, content ->
    }


    twoAndThree { x, y -> x + y }
    twoAndThree { x, y -> x * y }

    println("ab1c".filter { it in 'a'..'z'})


    processTheAnswer { number -> number+1 }
}