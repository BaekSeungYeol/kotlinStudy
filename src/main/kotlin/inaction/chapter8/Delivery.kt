package inaction.chapter8

enum class Delivery { STANDARD, EXPEDITED }

class Order(val itemCount: Int)

fun getShippingCostCalculator(
    delivery: Delivery
): (Order) -> Double {
    if (delivery == Delivery.EXPEDITED) {
        return { order -> 6 + 2.1 * order.itemCount }
    }
    return { order -> 1.2 * order.itemCount }
}

class ContactListFilters {
    var prefix: String = ""
    var onlyWithPhoneNumber: Boolean = false

    fun getPredidcate() : (Person) -> Boolean {
        val startsWithPrefix = { p: Person -> p.firstName.startsWith(prefix) || p.lastName.startsWith(prefix)}

        if(!onlyWithPhoneNumber) {
            return startsWithPrefix
        }
        return { startsWithPrefix(it) && it.phoneNumber != null}
    }
}
data class Person(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String?
)

fun main() {
    val calculator = getShippingCostCalculator(Delivery.STANDARD)
    println("Shopping cost = ${calculator(Order(3))}")

    val contacts = listOf(Person("Dmitry", "Jemerov", "123-4567") ,
        Person("Svetlana", "Isakova", null))

    val contactListFilters = ContactListFilters()
    with(contactListFilters) {
        prefix = "Dm"
        onlyWithPhoneNumber = true
    }
    println(contacts.filter(contactListFilters.getPredidcate()))

}