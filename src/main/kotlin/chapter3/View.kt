package chapter3

open class View {
    open fun click() = println("View Clicked")
}

class Button: View() {
    override fun click() = println("Button Clicked")
}

fun View.showOff() = println("I`m a view!")
fun Button.showOff() = println("I`m a button!")
fun main() {
    val v : View = Button()
    v.click()
    v.showOff()
}