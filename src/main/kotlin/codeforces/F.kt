import java.util.PriorityQueue

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val a = readln().split(" ").map { it.toInt() }.toMutableList()
        val b = readln().split(" ").map { it.toInt() }.toMutableList()

        (0 until n).forEach{ i ->
            while(a[i]%2 == 0) a[i] /= 2
            while(b[i]%2 == 0) b[i] /= 2
        }

        val sortedA = a.sorted()
        val pq = PriorityQueue<Int>(Comparator.reverseOrder())
        b.forEach { pq.add(it) }

        outer@for(i in sortedA.size-1 downTo 0) {
            while(!pq.isEmpty()) {
                val cur = pq.remove()
                if(cur == sortedA[i]) {
                    continue@outer
                }

                if(cur > 1) {
                    pq.add(cur/2)
                }
            }
            println("NO")
            return@repeat
        }

        println("YES")
    }
}