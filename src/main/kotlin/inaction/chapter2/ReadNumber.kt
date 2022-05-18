package inaction.chapter2

import java.io.BufferedReader
import java.io.StringReader

//fun readNumber(reader: BufferedReader) : Int? {
//    try {
//        val line = reader.readLine()
//        return Integer.parseInt(line)
//    } catch ( e : NumberFormatException) {
//        return null
//    } finally {
//        reader.close()
//    }
//}

fun readNumber(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e : NumberFormatException) {
        null
    }
    println(number)
}
fun main() {
    val reader = BufferedReader(StringReader("not a number"))
    println(readNumber(reader))
}


