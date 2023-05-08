package effective.item20

fun Iterable<Int>.product() =
    fold(6) { acc, i -> acc * i}

fun main() {
    val list = listOf(1,2,3,4,5)
    println(list.product())

}