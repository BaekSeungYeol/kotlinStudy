package codeforces

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val emptyString = readln()
        val (n,nq) = readln().split(" ").map{ it.toInt() }
        val a = readln().split(" ").map { it.toInt() }
        val first = HashMap<Int,Int>()
        val last = HashMap<Int,Int>()
        for(i in 0 until n) {
            last[a[i]] = i
        }
        for(i in n-1 downTo  0) {
            first[a[i]] = i
        }
        for(qq in 0 until nq) {
            val (aa,b) = readln().split(" ").map{ it.toInt()}
            if(first.containsKey(aa) && last.containsKey(b) && (first[aa]!! <= last[b]!!)) {
                println("YES")
            } else {
                println("NO")
            }
        }
    }
}

