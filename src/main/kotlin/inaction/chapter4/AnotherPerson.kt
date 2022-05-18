package inaction.chapter4

import chapter4.*

class AnotherPerson(val firstName: String, val lastName: String){
    companion object {

    }
}


fun AnotherPerson.Companion.fromJSON(json: String) : AnotherPerson {
    return AnotherPerson("a", "a")
}

fun main() {
    val p = AnotherPerson.fromJSON("aa")
}
