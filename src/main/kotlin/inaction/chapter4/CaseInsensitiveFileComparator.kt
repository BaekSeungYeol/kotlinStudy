package inaction.chapter4

import java.io.File

object CaseInsensitiveFileComparator : Comparator<File> {

    override fun compare(o1: File, o2: File): Int {
        return o1.path.compareTo(o2.path , ignoreCase = true)
    }
}

data class Person(val name: String) {
    object NameComparator : Comparator<Person> {
        override fun compare(o1: Person, o2: Person): Int {
            return o1.name.compareTo(o2.name)
        }
    }
}
fun main() {
    val files = listOf(File("/Z"), File("/a"))
    println(files.sortedWith(CaseInsensitiveFileComparator))

}
