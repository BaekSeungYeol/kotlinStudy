package effective.step2

class Person(
    val first: String,
    val middle: String?,
    val last: String
)

fun main() {

    val jkRowling = Person("Joanne", null, "Rowling")
    val northWest = Person("North", null, "West")

    var p = Person(first = "North", middle = null, last = "West")
    if(p.middle != null) {
        val middleNameLength = p.middle!!.length
    }

    val middleNameLength: Int = p.middle?.length ?: 0
    val p1 = p as? Person
}