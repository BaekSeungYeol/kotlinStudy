package codeforces

fun main() {

    val t = readln().toInt()
    repeat(t) {
        val (h, w) = readln().split(" ").map { it.toInt() }
        val arr = Array(h) { CharArray(w) }
        (1..h)
            .forEach {
                arr[it - 1] = readln().toCharArray()
            }

        for(x in 0 until w) {
            var nextSpace = h-1
            for(y in h-1 downTo 0) {
                if(arr[y][x] == 'o') {
                    nextSpace =y-1
                } else if(arr[y][x] == '*') {
                    arr[y][x] = '.'
                    arr[nextSpace][x] = '*'
                    nextSpace--
                }
            }
        }
        for(y in 0 until h) {
            println(arr[y])
        }

    }
}