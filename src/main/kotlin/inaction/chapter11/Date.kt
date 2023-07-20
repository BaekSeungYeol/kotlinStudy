package inaction.chapter11

import java.time.LocalDate
import java.time.Period

val Int.days: Period
    get() = Period.ofDays(this)
val Period.ago: LocalDate
    get() = LocalDate.now() - this
val Period.fromNow: LocalDate
    get() = LocalDate.now() + this


fun main() {
    val yesterday: LocalDate = 1.days.ago
    val tomorrow: LocalDate = 1.days.fromNow
}