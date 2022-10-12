package inaction.chapter9

import inaction.chapter8.joinToString
import kotlin.reflect.KClass

interface FieldValidator<in T> {
    fun validate(input: T): Boolean
}

object DefaultStringValidator : FieldValidator<String> {
    override fun validate(input: String) = input.isNotEmpty()
}

object DefaultIntValidator : FieldValidator<Int> {
    override fun validate(input: Int) = input >= 0
}

fun main() {
    val validators = mutableMapOf<KClass<*>, FieldValidator<*>>(
    )
    validators[String::class] = DefaultStringValidator
    validators[Int::class] = DefaultIntValidator

    val stringValidator = validators[String::class] as FieldValidator<String>
    println(stringValidator.validate(""))

}

fun printFirst(list: List<*>) {
    if (list.isNotEmpty()) {
        println(list.first())
    }
}
// fun <T> copyData(source: MutableList<T>, destination: MutableList<in T>) {
//     for(item in source) {
//         destination.add(item);
//     }
// }

fun printContents(list: List<Any>) {
    println(list.joinToString())
}

fun addAnswer(list: MutableList<Any>) {
    list.add(42)
}

// fun main() {
//     val strings = mutableListOf<String>("abc", "bac")
//     // addAnswer(strings)
// }

fun test(i: Int) {
    val n: Number = i
    fun f(s: String) {
    }
    // f(i)
}

interface Product<out T> {
    fun product(): T
}

open class Animal {
    fun feed() {
    }
}

class Herd<out T : Animal> {
    val size: Int
        get() = 3

    operator fun get(i: Int): T? {
        return null
    }
}

fun feedAll(animals: Herd<Animal>) {
    for (i in 0 until animals.size) {
        animals[i]?.feed()
    }
}

class Cat : Animal() {
    fun cleanLitter() {
    }
}

fun takeCareOfCats(cats: Herd<Cat>) {
    for (i in 0 until cats.size) {
        cats[i]?.cleanLitter()
    }
    feedAll(cats)
}

interface List<out T> : Collection<T> {
    fun subList(fromIndex: Int, toIndex: Int): List<T>
}

// interface MutableList<T> : List<T>, MutableCollection<T> {
//     override fun add(element: T): Boolean
// }

class Test<out T : Animal>(vararg animals: T) {}
