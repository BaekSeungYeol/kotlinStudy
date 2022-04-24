package chapter3


open class View {
    open fun click() = println("View Clicked")
}

class Button: View() {
    override fun click() = println("Button Clicked")
}

fun View.showOff() = println("I`m a view!")
fun Button.showOff() = println("I`m a button!")


val strings: List<String> = listOf("first", "second", "fourteenth")

var StringBuilder.lastChar : Char
    get() = get(length -1)
    set(value: Char) {
        this.setCharAt(length-1, value)
    }
fun main() {
    val v : View = Button()
    v.click()
    v.showOff()

    strings.last()
    val numbers: Collection<Int> = setOf(1,14,2)

}