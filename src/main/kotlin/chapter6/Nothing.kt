package chapter6

fun fail(message: String) : Nothing {
    throw IllegalStateException(message)
}
fun main() {
//    val address = company.address ?: fail("No Address")
//    println(address.city)
}