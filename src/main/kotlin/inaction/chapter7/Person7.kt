package inaction.chapter7

class Person71 {

    private val _attributes = hashMapOf<String, String>()
    fun setAttribute(attrName: String, value: String) {
        _attributes[attrName] = value
    }

    val name: String by _attributes
}

fun main() {
    val p = Person71()
    val data = mapOf("name" to "Dmitry", "company" to "JetBrains")
    for((attrName, value) in data)
        p.setAttribute(attrName, value)

    println(p.name)
}