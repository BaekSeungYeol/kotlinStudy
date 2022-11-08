import java.util.Arrays

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val input = Array(n) { mutableListOf<Int>() }
        (0 until n).forEach { i ->
            input[i] = readln().split(" ").map { it.toInt() }.toMutableList()
        }

        val withNumbers = Array(n) { mutableListOf<Int>() }

        for (i in 0 until n) {
            for (j in 0 until 2) {
                withNumbers[--input[i][j]].add(i)
            }
        }
        for(list in withNumbers) {
            if(list.size >= 3) {
                println("NO")
                return@repeat
            }
        }

        val adj = Array(n) { mutableListOf<Int>() }
        for (list in withNumbers) {
            adj[list[0]].add(list[1])
            adj[list[1]].add(list[0])
        }

        val visited = Array(n) { false }
        val color = Array(n) { false }
        var works = true
        val bfs = ArrayDeque<Int>()
        for (i in 0 until n) {
            if (visited[i]) continue
            visited[i] = true
            bfs.add(i)
            while (!bfs.isEmpty()) {
                val cur = bfs.removeFirst()
                for (next in adj[cur]) {
                    if (!visited[next]) {
                        visited[next] = true
                        color[next] = !color[cur]
                        bfs.add(next)
                    } else if (color[next] == color[cur]) {
                        works = false
                    }
                }
            }
        }
        println(if (works) "YES" else "NO")
    }
}