package inaction.chapter4

abstract class Animated {

    abstract fun animate()

    open fun stopAnimating() { }

    fun animateTwice() {}

}

class Cat : Animated() {
    override fun animate() {

    }

    override fun stopAnimating() {
        super.stopAnimating()
    }
}
fun main() {
    Cat().stopAnimating()
}
