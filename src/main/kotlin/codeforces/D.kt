import java.time.LocalTime
import java.time.format.DateTimeFormatter
import kotlin.time.Duration

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (time,jump) = readln().split(" ")
        val (hour, min) = time.split(":")
        val localTime = LocalTime.of(hour.toInt(), min.toInt())
        var ans = 0
        ans += if(checkPalindromes(localTime.toString())) 1 else 0
        var plusMinutes = localTime.plusMinutes(jump.toLong())
        // println("localDateTime String $localTime")
        // println("Time $plusMinutes")
        while(localTime.toString() != plusMinutes.toString()) {
            // println("plusMinutes = $plusMinutes")
            ans += if(checkPalindromes(plusMinutes.toString())) 1 else 0
            plusMinutes = plusMinutes.plusMinutes(jump.toLong())

        }
        println(ans)

    }
}

fun checkPalindromes(cur: String) : Boolean{
    val (hour, min) = cur.split(":")
    return hour.reversed() == min
}
