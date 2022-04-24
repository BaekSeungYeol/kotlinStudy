package chapter5

val runnable = Runnable { println(42) }

fun handleComputation() {
//    postponeComputation(1000, runnable)
}
fun handleComputation(id : String) {
//    postponeComputation(1000) { println(id)}
}

fun createAllDoneRunnable() : Runnable {
    return Runnable { println("All Done!")}
}

fun main() {
    createAllDoneRunnable().run()
}