package codeforces

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val arr = readln().split(" ").map { it.toInt() }

        val list = mutableListOf<Int>()
        val cs = Array(10) { 0 }
        for (a in arr.indices) {
            val num = arr[a]%10
            if (cs[num] + 1 <= 3) {
                cs[num]++
                list.add(num)
            }
        }

        // println(list)
        var works = false
        for (i in 0 until list.size) {
            for (j in i + 1 until list.size) {
                for (k in j + 1 until list.size) {
                    val number = (list[i] + list[j] + list[k]) % 10
                    works = works.or (number == 3)
                    // println(number)
                    // println(works)
                }
            }
        }
        println(if (works) "YES" else "NO")
    }
}