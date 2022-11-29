package inaction.appendix.`1`

fun main() {
    val l = listOf(1, 2, 3, 4, 5, 6, 7)
    println("l = $l")

    println("l.chuncked(size=3")
    l.chunked(size = 3).forEach { println(it) }

    println("l.windowed(size=3,step=1")
    l.windowed(size = 3, step = 1).forEach { println(it) }

    println("l.zipWithNext")
    l.zipWithNext { x, y -> println("{$x,$y}") }

    println("l.mychuncked(size=3")
    l.mychunked(size=3).forEach { println(it) }
    println("l.myZipWithNext")
    l.myZipWithNext{x,y -> println("($x,$y)")}

    val items = (1..5).toMutableList()
    items.shuffle()
    println(items)

    items.replaceAll { it * 2}
    println(items)

    items.fill(5)
    println(items)
}

fun <T> List<T>.mychunked(size: Int) = windowed(size, size)
fun <T, R> List<T>.myZipWithNext(f: (T, T) -> R) =
    windowed(size = 2, step = 1)
        .filter { it.size == 2 }
        .map { (x, y) -> f(x, y) }
