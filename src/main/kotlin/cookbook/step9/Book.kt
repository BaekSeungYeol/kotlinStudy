package cookbook.step9

import java.time.LocalDate

fun createBook(
    isbn: String = "149197317X",
    title: String = "Modern Java Recipes",
    author: String = "Ken Kousen",
    published: LocalDate = LocalDate.parse("2017-08-26")
) = Book(isbn, title, author, published)

data class Book(
    val isbn: String,
    val title: String,
    val author: String,
    val published: LocalDate
)

@JvmOverloads
tailrec fun fibonacci(n: Int, a: Int = 0, b: Int = 1): Int =
    when(n) {
        0 -> a
        1 -> b
        else -> fibonacci(n-1,b,a+b)
    }
