package cookbook.step6.`6-4`

import kotlin.math.ceil
import kotlin.math.sqrt

fun Int.isPrime() =
    this == 2 || (2..ceil(sqrt(this.toDouble())).toInt())
         .none { divisor -> this % divisor == 0 }

fun nextPrime(num: Int) =
    generateSequence(num+1) { it + 1 }
        .first(Int::isPrime)

fun firstNPrimes(count: Int) =
    generateSequence(2, ::nextPrime)
        .take(count)
        .toList()

fun primesLessThan(max: Int) : List<Int> =
    generateSequence(2) { n -> if ( n < max) nextPrime(n) else null }
        .toList()
        .dropLast(1)

fun primesLessThan2(max: Int) : List<Int> =
    generateSequence(2, ::nextPrime)
        .takeWhile { it < max }
        .toList()

fun fibonacciSequence() = sequence {
    var terms = Pair(0,1)

    while(true) {
        yield(terms.first)
        terms = terms.second to terms.first + terms.second
    }
}

val sequence = sequence {
    val start = 0
    yield(start)
    yieldAll(1..5 step 2)
    yieldAll(generateSequence(8) { it * 3 })
}
fun main() {
    val numSequence1 = sequenceOf(3,1,4,1,5,9)
    val numSequence2 = listOf(3,1,4,1,5,9).asSequence()

    println(nextPrime(3))
}