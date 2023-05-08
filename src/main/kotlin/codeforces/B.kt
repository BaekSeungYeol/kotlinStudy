
fun main() {

    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val nums = readln().split(" ").map { it.toInt() }.toList()
        var maxIdx = 0
        nums.forEachIndexed {index, num ->
            if(nums[maxIdx] < num) {
                maxIdx = index
            }
        }
        var work = true
        for(i in 0 until maxIdx) {
            work = work and (nums[i] <= nums[i+1])
        }
        for(i in maxIdx until  n-1) {
            work = work and (nums[i] >= nums[i+1])
        }
        println(if(work) "yes" else "no")
    }
}
