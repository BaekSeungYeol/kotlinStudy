package inaction.chapter2

import inaction.chapter2.Color.YELLOW


enum class Color(
    val r: Int, val g: Int, var b: Int
) {
    RED(255,0,0), ORANGE(255,165,0),
    YELLOW(255,255,0), GREEN(0,255,0), BLUE(0,0,255),
    INDIGO(75,0,130), VIOLET(238,130,238); // 상수 목록과 메소드 정의 사이에 넣는 세미콜론

    fun rgb() = (r * 256 + g) * 256 + b
}

fun mix(c1: Color, c2: Color) =
    when(setOf(c1,c2)) {
        setOf(Color.RED, YELLOW) -> Color.ORANGE
        setOf(YELLOW, Color.BLUE) -> Color.GREEN
        setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
        else -> throw Exception("Dirty color")
    }

fun mixOptimized(c1 : Color, c2: Color) =
    when {
        (c1 == Color.RED && c2 == YELLOW) ||
                (c1 == YELLOW && c2 == Color.RED) -> Color.ORANGE
        (c1 == Color.YELLOW && c2 == Color.BLUE) ||
                (c1 == Color.BLUE && c2 == Color.YELLOW) -> Color.GREEN
        (c1 == Color.BLUE && c2 == Color.VIOLET) ||
                (c1 == Color.VIOLET && c2 == Color.BLUE) -> Color.INDIGO
        else -> throw Exception("Dirty Color")
    }
fun main() {
    println(Color.BLUE.rgb())
    println(mix(Color.BLUE, YELLOW))
    println(mixOptimized(Color.BLUE, YELLOW))
}


