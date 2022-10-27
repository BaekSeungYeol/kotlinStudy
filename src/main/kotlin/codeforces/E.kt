fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()

        val cs = Array(600 * 600) { 0 }

        var ans = 0L
        (1..n)
            .map { readln() }
            .forEach { s ->
                ('a'..'k').forEach {
                    if(s[0] == it) {
                        return@forEach
                    }
                    val copy = it.toString() + s[1].toString()
                    ans += cs[toInt(copy)]
                }
                ('a'..'k').forEach {
                    if(s[1] == it) {
                        return@forEach
                    }
                    val copy = s[0].toString() + it.toString()
                    ans += cs[toInt(copy)]
                }
                cs[toInt(s)]++
            }
        println(ans)
    }

}
fun toInt(s: String) : Int {
    return s[0].code * 600 + s[1].code
}
