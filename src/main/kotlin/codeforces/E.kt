fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val input = Array(n) { mutableListOf<Int>() }
        for (i in 0 until n) {
            input[i] = readln().split(" ").map { it.toInt() }.toMutableList()
        }
        val withNum = Array(n) { mutableListOf<Int>() }
        for (i in 0 until n) {
            for (j in 0 until 2) {
                withNum[--input[i][j]].add(i)
            }
        }

        for (list in withNum) {
            if (list.size >= 3) {
                println("NO")
                return@repeat
            }
        }

        val adj = Array(n) { mutableListOf<Int>()}
        for (list in withNum) {
            for (i in 0 until list.size) {
                for (j in i + 1 until list.size) {
                    adj[list[i]].add(list[j])
                    adj[list[j]].add(list[i])
                }
            }
        }

        // check if bipartite
        var works = true
        val bfs = ArrayDeque<Int>()
        val visited = Array(n) { false }
        val color = Array(n) { false }
        for (i in 0 until n) {
            if (visited[i]) continue
            visited[i] = true
            bfs.add(i)
            while (bfs.isNotEmpty()) {
                val at = bfs.removeFirst()
                for (other in adj[at]) {
                    if (!visited[other]) {
                        visited[other] = true
                        color[other] = !color[at]
                        bfs.add(other)
                    } else if (color[other] == color[at]) {
                        works = false
                    }
                }
            }
        }
        println(if (works) "YES" else "NO")
    }
}
