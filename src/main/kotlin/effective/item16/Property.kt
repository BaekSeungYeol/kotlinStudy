package effective.item16

import java.time.ZonedDateTime

var name: String? = null
    get() = field?.toUpperCase()
    set(value) {
        if (!value.isNullOrBlank()) {
            field = value
        }
    }

val fullName: String
    get() = "$name test"

interface Person {
    val name: String
}

open class Supercomputer {
    open val theAnswer: Long = 42
}

class AppleComputer : Supercomputer() {
    override val theAnswer: Long = 1_800_275_2273
}

// fun Tree<Int>.sum(): Int = when(this) {
//     is Leaf -> value
//     is Node -> left.sum() + right.sum()
// }

val AppleComputer.yourAnswer: Long
    get() = 1_900L
fun main() {
    println(AppleComputer().yourAnswer)
}