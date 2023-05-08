package effective.item21

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

fun main() {

    val gift = Gift()

    println("Before")
    gift.items = listOf(
        Item("name1"),
        Item("name2"),
        Item("name3")
    )
    println("After")
}

fun notifyDataSetChanged() {
    println("Notify Data Changed")

    val map: Map<String, Any> = mapOf(
        "name" to "Marcin",
        "kotlinProgrammer" to true
    )

    val name by map
    print(name)
}

class Gift {
    var items: List<Item> by
    Delegates.observable(listOf()) { _, _, _ -> notifyDataSetChanged() }

    // var token: String? = null
    //     get() {
    //         print("token returned value $field")
    //         return field
    //     }
    //     set(value) {
    //         print("token changed from $field to $value")
    //         field = value
    //     }
    //
    // var attempts: Int = 0
    //     get() {
    //         print("attempts returned value $field")
    //         return field
    //     }
    //     set(value) {
    //         print("attempts changed from $field to $value")
    //         field = value
    //     }

    var token: String? by LoggingProperty(null)
    var attempts: Int by LoggingProperty(0)

}

private class LoggingProperty<T>(var value: T) {
    operator fun getValue(
        thisRef: Any?,
        prop: KProperty<*>
    ) : T {
        println("${prop.name} returned value $value")
        return value
    }
    operator fun setValue(
        thisRef: Any?,
        prop: KProperty<*>,
        newValue: T
    ) {
        val name = prop.name
        print("$name changed from $value to $newValue")
        value = newValue
    }
}

data class Item(
    var name: String
)