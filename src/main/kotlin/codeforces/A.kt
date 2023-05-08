fun main() {

    val T = readln().toInt()
    for (tt in 0 until T) {
        var minX = 0
        var maxX = 0
        var minY = 0
        var maxY = 0
        val n = readln().toInt()
        for (i in 0 until n) {
            val (x,y) = readln().split(" ").map{ it.toInt() }
            minX = minX.coerceAtMost(x)
            minY = minY.coerceAtMost(y)
            maxX = maxX.coerceAtLeast(x)
            maxY = maxY.coerceAtLeast(y)
        }
        println(((maxX - minX) + (maxY - minY)) * 2)
    }
}