package inaction.chapter5

class Book(val title: String, val authors: List<String>){}

fun main() {

    val strings = listOf("abc", "def")
    println(strings.flatMap { it. toList() })

    val books = listOf(Book("Thursday Next", listOf("Jasper Fforde")),
    Book("Mort", listOf("Terry Practchett")),
    Book("Good Omens", listOf("Terry pratchett", "Neil Gaiman")))

    println(books.flatMap { it.authors}.toSet())
}