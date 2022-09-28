package cookbook.step5

import java.time.LocalDate

fun main() {
    val list = listOf("a", LocalDate.now(), 3, 1, 4, "b")
    // val strings = list.filter { it is String }

    // for(s in strings) {
    //     println(s)
    // }

    // val all = list.filterIsInstance<Any>()
    // val strings = list.filterIsInstance<String>()
    // val ints = list.filterIsInstance<Int>()
    // val dates = list.filterIsInstance(LocalDate::class.java)

    val all = list.filterIsInstanceTo(mutableListOf<Any>())
    val strings = list.filterIsInstanceTo(mutableListOf<String>())
    val ints = list.filterIsInstanceTo(mutableListOf<Int>())
    val dates = list.filterIsInstanceTo(mutableListOf<LocalDate>())

    println(all)
    println(strings)
    println(ints)
    println(dates)
}