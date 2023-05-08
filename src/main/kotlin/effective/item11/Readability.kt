package effective.item11

fun main() {

    val person = Person(true)

    // A
    if(person != null && person.isAdult) {
        println("adult")
        println("next")

    } else {
        println("child")
        println("next")
    }

    // B
    person?.takeIf { it.isAdult }
        ?.let {
            println("adult")
            println("next")
        }
        ?: run {
            println("child")
            println("next")
        }

    val students = listOf("a","b","c","d")


    // A
    students.filter { it.isNotEmpty()}
        .joinToString(separator = "\n") {
            "$it $it $it"
        }
        .let(::println)

    // B
    println(students.filter { it.isNotEmpty()}
        .joinToString(separator = "\n") {
            "$it $it $it"
        })


    val abc = "A" { "B" } and "C"
    print(abc)
}

operator fun String.invoke(f: () -> String) : String = this + f()
infix fun String.and(s: String) = this + s

data class Person(
    val isAdult: Boolean
)