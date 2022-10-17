package inaction.chapter10

import com.fasterxml.jackson.databind.ser.std.DateSerializer
import java.util.Date
import kotlin.reflect.KClass

class HasTempFolder {

    fun test(list: List<*>) {
        @Suppress("UNCHECKED_CAST")
        val strings = list as List<String>
    }
}

@Target(AnnotationTarget.PROPERTY)
annotation class JsonExclude
annotation class JsonName(val name: String)

@Target(AnnotationTarget.ANNOTATION_CLASS)
annotation class BindingAnnotation

@BindingAnnotation
annotation class MyBinding

interface Company {
    val name: String
}

data class CompanyImpl(override val name: String) : Company

data class Person(
    val name: String,
    @DeserializeInterface(CompanyImpl::class) val company: Company
)

annotation class DeserializeInterface(val targetClass: KClass<out Any>)

interface ValueSerializer<T> {
    fun toJsonValue(value: T) : Any?
    fun fromJsonValue(jsonValue: Any?) : T
}

data class Person2(
    val name: String,
    // @CustomSerializer(DateSerializer::class) val birthDate: Date
)

annotation class CustomSerializer(
    val serializerClass: KClass<out ValueSerializer<*>>
)
