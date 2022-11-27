package inaction.appendix

fun main() {
    val nums = listOf(1,2,3)
    val names = listOf("One", "Two", "Three")

    (nums zip names).forEach { (num,name) ->
        println("$num = $name")
    }
}