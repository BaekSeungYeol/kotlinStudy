package inaction.chapter4

class OtherUser(val name: String) {
    var address: String = "unspecified"
        set(value: String) {
            println("""
                Address was changed for $name:
                "$field" -> "$value"
            """.trimIndent())

            field = value
        }
}

fun main() {
    val user = OtherUser("Alice")
    user.address = "Elsenheimerstrasse 47 80687 Muenchen"
}
