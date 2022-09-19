package effective.item8

fun largestOf(vararg nums: Int) : Int = nums.maxOf { it }
fun main() {
    largestOf()
}