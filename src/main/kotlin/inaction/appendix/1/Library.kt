package inaction.appendix.`1`

class MyClass {
    val num: Int = 0

    fun foo(v: MyClass) {
        val result = v.apply {
            this.num
            this@MyClass.num
        }
    }
    fun foo2(v: MyClass) {
        val result = v.also {
            this.num
            it.num
        }
    }
}
fun main() {
    listOf(1,2,3,4,5).onEach { println("${it}") }.map {it * it}.joinToString(",")

    val test = "aaa".takeIf { it.contains("a")} ?: "none"
    val test2 = "aaa".takeIf { it.contains("b")} ?: "none"
    println(test)
    println(test2)

    val groupingBy = (1..100).groupingBy { it % 3 }.eachCount()
    println(groupingBy)
}