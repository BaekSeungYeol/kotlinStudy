package codeforces

import java.util.TreeSet

fun main() {

    val t = readln().toInt()
    repeat(t) {
        val (n,k) = readln().split(" ").map{it.toInt()}
        val arr = readln().split(" ").map{ it.toInt() }
        var ans = 0
        val breaks = TreeSet<Int>()
        breaks.add(n-1)
        for(i in 0 until n-1) {
            if(arr[i] >= arr[i+1]*2) {
                breaks.add(i)
            }
        }
        for(i in 0 until n) {
            val next = breaks.ceiling(i)
            if(next -i  >= k) {
                ans++
            }
        }
        println(ans)
    }
}