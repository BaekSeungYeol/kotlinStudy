package cookbook.step8

import kotlin.properties.Delegates

interface Dialable {
    fun dial(number: String): String
}

class Phone: Dialable {
    override fun dial(number: String): String {
        return "Dialing $number..."
    }
}

interface Snappable {
    fun takePicture() : String
}

class Camera: Snappable {
    override fun takePicture() =
        "Taking picture..."
}

class SmartPhone(
    private val phone: Dialable = Phone(),
    private val camera: Snappable = Camera()
) : Dialable by phone, Snappable by camera

val ultimateAnswer: Int by lazy {
    println("computing the answer")
    42
}

var shouldNotBeNull: String by Delegates.notNull<String>()

var watched: Int by Delegates.observable(1) { property, oldValue, newValue ->
  println("${property.name} changed from $oldValue to $newValue")
}

var checked: Int by Delegates.vetoable(0) { property, oldValue, newValue ->
    println("Trying to change ${property.name} from $oldValue to $newValue")
    newValue >= 0
}

data class Project(val map: MutableMap<String, Any?>) {
    val name: String by map
    var priority: Int by map
    var completed: Boolean by map
}
fun main() {
    println(ultimateAnswer)
    println(ultimateAnswer)
    println(shouldNotBeNull)
}