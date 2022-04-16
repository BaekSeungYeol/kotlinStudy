package chapter4

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable")
}

class Button: Clickable, Focusable{
    override fun click() = println("I was Clicked")
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

fun main() {
    val button = Button()
    button.showOff()
    button.setFocus(true)
    button.click()
}
