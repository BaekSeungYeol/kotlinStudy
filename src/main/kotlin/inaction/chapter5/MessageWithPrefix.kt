package inaction.chapter5

import inaction.chapter3.Button
import inaction.chapter4.AnotherPerson

fun printMessagesWithPrefix(messages: Collection<String>, prefix: String) {
    messages.forEach {
        println("$prefix $it")
    }
}

//fun tryToCountButtonClicks(button: Button) : Int {
//    var clicks = 0
//    button.onClick { clicks ++ }
//    return clicks
//}

fun sendEmail(person: Person, message: String) {
    println("Send Email")
}
fun main() {

    val errors = listOf("403 Forbidden", "404 Not Found")
    printMessagesWithPrefix(errors, "Error: ")


    val action = { person: Person, message: String ->
        sendEmail(person, message)
    }

    val nextAction = ::sendEmail

    val createPerson = ::Person


    val p = createPerson("Alice", 29)
    val personAgeFunction = Person::age
    println(personAgeFunction(p))

    val dmitrysAgeFunction = p::age
    println(dmitrysAgeFunction())
}

fun Person.isAdult() = age >= 21
