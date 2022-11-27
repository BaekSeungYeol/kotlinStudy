package inaction.appendix

data class V(val value: Int) {
    infix operator fun rem(other: V) = V(10)
    // infix operator fun mod(other: V) = V(-10)

}
fun main() {
    val x = V(5)
    val y = V(7)
    val r1 = x % y
    val r2 = x rem y
    println(r1)
    println(r2)
}