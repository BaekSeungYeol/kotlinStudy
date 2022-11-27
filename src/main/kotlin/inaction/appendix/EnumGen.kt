package inaction.appendix

enum class DAYSOFWEEK { MON, TUE, WED, THR, FRI, SAT, SUN }
enum class MONTHSOFWEEK { JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, ACT, NOV, DEC}
inline fun <reified T: Enum<T>> mkString(): String =
    buildString {
        for(v in enumValues<T>()) {
            append(v)
            append(",")
        }
    }

fun main() {
    println(mkString<DAYSOFWEEK>())
    println(mkString<MONTHSOFWEEK>())
}