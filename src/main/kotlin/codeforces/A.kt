package codeforces

fun main() {

    val t = readln().toInt()
    repeat(t) {
        val s = readln().toCharArray()
        val memory = HashSet<Char>()
        var totalDay = 0
        s.forEach {
           memory.add(it)
            if(memory.size == 4) {
                memory.clear()
                memory.add(it)
                totalDay += 1
            }
        }
        if(memory.isNotEmpty()) totalDay += 1
        println(totalDay)

    }
}

