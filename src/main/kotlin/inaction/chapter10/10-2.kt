package inaction.chapter10

import kotlin.reflect.KProperty1
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.memberProperties

class Person3(val name: String, val age: Int)

fun foo(x: Int) = println(x)

var counter = 0
val kProperty = ::counter

fun main() {
    val person = Person3("Alice", 29)
    val kClass = person.javaClass.kotlin
    println(kClass.simpleName)

    val kFunction = ::foo
    kFunction.call(42)
    kFunction.invoke(42)
    kProperty.setter.call(21)
    println(kProperty.get())
}

private fun StringBuilder.serializeObject(obj: Any) {
    val kClass = obj.javaClass.kotlin.memberProperties
        .filter { it.findAnnotation<JsonExclude>() == null }
        // .joinToStringBuilder { serializeProperty(it, obj) }
}

private fun StringBuilder.serializeProperty(
    prop: KProperty1<Any, *>, obj: Any
) {
    val jsonNameAnn = prop.findAnnotation<JsonName>()
    val propName = jsonNameAnn?.name ?: prop.name
}
