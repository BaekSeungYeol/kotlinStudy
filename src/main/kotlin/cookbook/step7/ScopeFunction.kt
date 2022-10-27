package cookbook.step7

class Site(val name: String,
val latitude: Double,
val longitude: Double)

fun processString(str: String) =
    str.let {
        when {
            it.isEmpty() -> "Empty"
            it.isBlank() -> "Blank"
            else -> it.capitalize()
        }
    }

data class AstroResult(
    val message: String,
    val number: Number,
    val people: List<Assignment>
)
data class Assignment(
    val craft: String,
    val name: String
)
fun main() {

    // before refactoring
    val numbers = mutableListOf("one", "two", "three", "four", "five")
    val resultList = numbers.map { it.length } .filter { it > 3 }
    println(resultList)

    // after refactoring
    val numbers2 = mutableListOf("one", "two", "three", "four", "five")
    numbers.map { it.length }.filter { it > 3 }.let(::println)

}