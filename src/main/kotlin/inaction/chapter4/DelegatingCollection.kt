package inaction.chapter4

class DelegatingCollection<T>(
        innerList: Collection<T> = ArrayList<T>()
) : Collection<T> by innerList {}
//class DelegatingCollection<T> : Collection<T> {
//    private val innerList = arrayListOf<T>()
//    override val size: Int
//        get() = innerList.size
//
//    override fun contains(element: T): Boolean {
//        return innerList.contains(element)
//    }
//
//    override fun containsAll(elements: Collection<T>): Boolean {
//        return innerList.containsAll(elements)
//    }
//
//    override fun isEmpty(): Boolean {
//        return innerList.isEmpty()
//    }
//
//    override fun iterator(): Iterator<T> {
//        return innerList.iterator()
//    }
//}

class CountingSet<T>(
        private val innerSet: MutableCollection<T> = HashSet<T>()
) : MutableCollection<T> by innerSet {
    var objectsAdded = 0

    override fun add(element: T) : Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(c: Collection<T>) : Boolean {
        objectsAdded += c.size
        return innerSet.addAll(c)
    }
}

fun main() {
    val cset = CountingSet<Int>()
    cset.addAll(listOf(1,1,2))
    println("${cset.objectsAdded} objects were added, ${cset.size} remain")
}
