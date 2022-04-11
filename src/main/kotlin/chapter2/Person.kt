package chapter2

class Person(val name: String, var isMarried: Boolean)

fun main() {
    val person1 = Person("아무개", false)
    println(person1.name)
    println(person1.isMarried)
}