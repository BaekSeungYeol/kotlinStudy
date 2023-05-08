package effective.item15


fun <T: Comparable<T>> List<T>.quickSort(): List<T> {
    if(size < 2) return this

    val pivot = this.first()
    val (smaller, bigger) = this.drop(1)
        .partition { it < pivot }

    return smaller.quickSort() + pivot + bigger.quickSort()
}

fun main() {
    // val list = listOf(3, 2, 9, 5, 4)
    // val quickSortList = list.quickSort()
    // println(quickSortList)

    val node = Node("parent")
    node.makeChild("child")
}

// class Node(val name: String) {
//
//     fun makeChild(childName: String)  =
//         create("$name.$childName")
//             .also { print("Created ${it?.name}")}
//
//     private fun create(name: String): Node? = Node(name)
// }

class Node(val name: String) {

    fun makeChild(childName: String)  =
        create("$name.$childName")
            .apply { print("Created ${this?.name} in" +
            " ${this@Node.name}")}

    private fun create(name: String): Node? = Node(name)
}
