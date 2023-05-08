package effective.item24

import java.util.stream.Collectors
import java.util.stream.Stream
import java.util.stream.Stream.*

// class Cup<T>

fun main() {
    // val anys: Cup<Any> = Cup<Int>() // Type mismatch
    // val nothings: Cup<Nothing> = Cup<Int>() // ERROR

    // --- out
    // val a: Cup<Dog> = Cup<Puppy>() // OK
    // val b: Cup<Puppy> = Cup<Dog>() // ERROR

    // --- in
    // val anys: Cup<Dog> = Cup<Puppy>() // ERROR
    // val b: Cup<Puppy> = Cup<Dog>() // OK

    // val intToDouble: (Int) -> Number = { it.toDouble() }
    // val numberAsText: (Number) -> Any = { it.toShort() }
    // val identity: (Number) -> Number = { it }
    // val numberToInt: (Number) -> Int = {it.toInt()}
    // val numberHash: (Any) -> Number = {it.hashCode()}
    // printProcessedNumber(intToDouble)
    // printProcessedNumber(numberAsText)
    // printProcessedNumber(identity)
    // printProcessedNumber(numberToInt)
    // printProcessedNumber(numberHash)
    //
    // val s1 = listOf("1","2","3")
    // val s2 = listOf("4","5","6")
    // val s3 = concat(s1.stream(),s2.stream())
    //     .collect(Collectors.toList())
    // println(s3)

    // val sample = Sample("aa",12)
    //
    // val copy = sample.copy("bb", 3)
    // println(sample.name)
    // println(sample.age)
    //
    // val helpByCategory = mutableMapOf<String, MutableMap<String, String>>()
    //
    // helpByCategory.computeIfAbsent("a") { mutableMapOf() }["bb"] = "bbb"
    //
    // println(helpByCategory)
}
data class Sample(
    val name: String,
    val age: Int
)

// class Cup<out T>
// open class Dog
// class Puppy: Dog()

class Cup<in T>
open class Dog
class Puppy() : Dog()

fun printProcessedNumber(transition: (Int)->Any) {
    print(transition(42))
}