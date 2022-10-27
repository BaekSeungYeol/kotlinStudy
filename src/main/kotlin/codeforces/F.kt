package codeforces

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val arr = readln().split(" ").map{ it.toInt() }
        var left = 0
        var right = n-1
        var lSum = arr[left]
        var rSum = arr[right]
        var ans = 0
        while(left < right) {
            if (lSum > rSum) {
                right--
                rSum += arr[right]
            } else if (lSum < rSum) {
                left++
                lSum += arr[left]
            } else if(lSum == rSum) {
                ans = (left + 1) + (n - right)
                left++
                right--
                lSum += arr[left]
                rSum += arr[right]
            }
        }
        println(ans)
    }
}