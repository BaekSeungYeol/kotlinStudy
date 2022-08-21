package effective.item1

var name: String = "Marcin"
var surname: String = "Moskala"
val fulName
    get() = "$name $surname"

fun calculate(): Int {
    print("Calculating... ")
    return 42
}

val fizz = calculate()
val buzz
    get() = calculate()


interface Element {
    val active: Boolean
}

class ActualElement : Element {
    override var active: Boolean = false
}

fun main() {
    println(fulName)
    name = "Maja"
    println(fulName)

    print(fizz)
    print(fizz)
    print(buzz)
    print(buzz)

}