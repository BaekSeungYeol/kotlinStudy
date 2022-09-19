fun main() {
    val t = readln().toInt()
        repeat(t) {
            val (n, s) = readln().split(" ").map { it.toInt() }
            val arr = readln().split(" ").map { it.toInt() }
            val indexOf = Array(n + 1) { -1 }
            var sum = 0
            for (i in 0 until n) {
                if (arr[i] == 1) {
                    sum++
                    indexOf[sum] = i
                }
            }
            if (s > sum) {
                println(-1)
                return@repeat
            }
            val sub = sum - s
            var ans = indexOf[sub] + 1
            for (l in 0..sub) {
                val lCost = if (l == 0) 0 else indexOf[l] + 1
                val kth = sub - l
                val rCost = if (l==sub) 0 else n - indexOf[sum - kth + 1]
                ans = ans.coerceAtMost(lCost + rCost)
            }
            println(ans)
    }
}