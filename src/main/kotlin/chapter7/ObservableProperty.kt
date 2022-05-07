package chapter7

import java.beans.PropertyChangeSupport
import kotlin.reflect.KProperty

class ObservableProperty(
    var propValue: Int,
    val changeSupport: PropertyChangeSupport
) {
    operator fun getValue(p: NewPerson, prop: KProperty<*>) : Int = propValue
    operator fun setValue(p: NewPerson, prop: KProperty<*>, newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }
}