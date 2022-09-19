package cookbook.step5

data class Golfer(val score: Int, val first: String, val last: String)

val golfers = listOf(
    Golfer(70, "Jack", "Nicklaus"),
    Golfer(68, "Tom", "Watson"),
    Golfer(68, "Bubba", "Watson"),
    Golfer(70, "Tiger", "Woods"),
    Golfer(68, "Ty", "Webb"),
)

fun main() {
    val sorted = golfers
        .sortedWith(compareByDescending { it.score })
        .sortedWith(compareBy({ it.last }, { it.first }))
    sorted.forEach {
        println(it)
    }

    val comparator = compareByDescending<Golfer>(Golfer::score)
        .thenBy(Golfer::last)
        .thenBy(Golfer::first)

    golfers.sortedWith(comparator)
        .forEach(::println)
}