package cookbook.step3

class Customer2(val name: String) {
    val messages: List<String> by lazy { loadMessages() }

    private fun loadMessages() : MutableList<String> =
        mutableListOf(
            "Initial contact",
            "Convinced them to use Kotlin",
            "Sold training class. Sweet."
        ).also { println("Load Messages") }
}
fun main() {

}