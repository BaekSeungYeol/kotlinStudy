package inaction.chapter3

fun <T> Collection<T>.joinToString(
    collection: Collection<T>,
    seperator: String = ", ",
    prefix: String = "",
    postfix: String = ""
) : String {
    val sb = StringBuilder(prefix)
    for((index,element) in collection.withIndex()) {
        if(index > 0) sb.append(seperator)
        sb.append(element)
    }
    sb.append(postfix)
    return sb.toString()
}
fun main() {
    val list = listOf(1,2,3)
    println(list.joinToString(collection = list, seperator = "; ", prefix = "(", postfix = ")"))
}
