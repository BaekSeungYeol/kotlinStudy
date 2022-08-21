package effective.item8

fun main() {

    val list = listOf<Map<Int,Int>>()

    val emptyMap = list[0].orEmpty()

    println(emptyMap)

}