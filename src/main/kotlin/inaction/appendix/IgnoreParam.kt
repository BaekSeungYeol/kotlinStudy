package inaction.appendix

data class YMD(val year: Int, val month: Int, val day: Int)

typealias YMDFUN = (YMD) -> Unit
fun applyYMD(v: YMD, f: YMDFUN) = f(v)
val now = YMD(2017,10,9)
val 삼일운동 = YMD(1919,3,1)

fun main() {
    val (삼일운동이_일어난_해, _, _) = 삼일운동
    applyYMD(now) { (year,month,_) -> println("year =$year, month = $month")}
}