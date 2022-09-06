package inaction.chapter9

import java.util.ServiceLoader


fun <T : Comparable<T>> max(first: T, second: T): T {
    return if (first > second) first else second
}

fun <T> ensureTrailingPeriod(seq: T) where T : CharSequence, T : Appendable {
    if (!seq.endsWith('.')) {
        seq.append('.')
    }
}

fun printSum(c: Collection<*>) {
    val intList = c as? List<Int> ?: throw IllegalArgumentException("List is expected")
}

fun printSum2(c: Collection<Int>) {
    if(c is List<Int>) {
        println(c.sum())
    }
}

class Processor<T : Any> {
    fun process(value: T) {
        // value?.hashCode()
        value.hashCode()
    }
}

inline fun <reified T> isA(value: Any) = value is T

inline fun <reified T> loadService(): ServiceLoader<T>? {
    return ServiceLoader.load(T::class.java)
}

interface Function1<in P, out R> {
    operator fun invoke(p: P) : R
}

fun enumerateCats(f : (Cat) -> Number) {

}
fun Animal.getIndex() : Int = 0

fun <T> copyData(source: MutableList<out T>, destination: MutableList<T>) {
    for(item in source) {
        destination.add(item)
    }
}

fun main() {
    println(max("kotlin", "java"))
    // println(max("kotlin", 42))


    println(isA<String>("abc"))
    println(isA<String>(123))

    val items = listOf("one", 2, "three")
    println(items.filterIsInstance<String>())
    enumerateCats(Animal::getIndex)

    val ints = mutableListOf(1,2,3)
    val anyItems = mutableListOf<Any>()
    // copyData(ints,anyItems) ??
    println(anyItems)

}
