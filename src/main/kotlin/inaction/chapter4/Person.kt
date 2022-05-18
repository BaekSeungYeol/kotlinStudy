package inaction.chapter4

interface JSONFactory<T> {
    fun fromJSON(jsonText: String) : T
}
class Person2(val name: String) {
    companion object : JSONFactory<String> {
        override fun fromJSON(jsonText: String) : String = ""
    }
}

fun <T> loadFromJson(factory: JSONFactory<T>) : T {
    return factory.fromJSON("")
}
fun main() {
    loadFromJson(Person2)
}
