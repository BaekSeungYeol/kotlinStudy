import kotlin.math.min

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        var start = 0
        while(start * start <= n) start += 1
        val arr = IntArray(n)
        var earlistPlaceAt = n
        var minimumNum = n
        var toPlace = n-1

        while(toPlace >= 0) {
            val curIndex = start * start - toPlace
            if(curIndex >= earlistPlaceAt) {
                start--
                earlistPlaceAt = minimumNum
                continue
            }
            arr[curIndex] = toPlace--
            minimumNum = min(minimumNum, curIndex)
        }
        for(a in arr) {
            print("$a ")
        }
        println()
    }
}