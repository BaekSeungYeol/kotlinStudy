package chapter7

import java.beans.PropertyChangeListener

class Person7(
    val name: String, age: Int, salary: Int
) : PropertyChangeAware() {

    var age: Int = age
    set(newValue) {
        val oldValue = field
        field = newValue
        changeSupport.firePropertyChange("age", oldValue, newValue)
    }
}

fun main() {
    val p = Person7("Dmitry", 34, 2000)
    p.addPropertyChangeListener { event ->
        println(
            "Property ${event.propertyName} changed" +
                "from ${event.oldValue} to ${event.newValue}"
        )
    }
    p.age = 35
}