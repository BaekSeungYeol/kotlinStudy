package inaction.chapter5

val sum = { x : Int, y : Int -> x + y}

val sum2 = {x: Int, y: Int ->
    println("Computing the sum of $x and $y ...")
    x+y
}
fun main() {

    println(sum(1,3))
    println(sum2(1,3))
}