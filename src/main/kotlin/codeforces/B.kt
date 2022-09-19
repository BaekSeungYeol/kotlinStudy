
fun main() {

    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val nums = readln().split(" ").map { it.toInt() }.toSet()
        val remain = n - nums.size
        println(if(remain%2 == 0) nums.size else nums.size -1)
    }
}