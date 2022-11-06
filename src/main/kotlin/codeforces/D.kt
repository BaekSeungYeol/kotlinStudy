
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val w = readln().toCharArray()
        val n = w.size
        var maxNum = readln().toInt()
        for (c in w) {
            maxNum -= (c - 'a' + 1)
        }
        val killed = Array(n) { false }
        val choices = Array(n) { Choice((w[it] - 'a' + 1), it) }
        choices.sortDescending()
        // choices.forEach {
        //     println(it)
        // }
        for (i in 0 until n) {
            if (maxNum < 0) {
                maxNum += choices[i].cost
                killed[choices[i].index] = true
            }
        }
        // killed.forEach {
        //     print("$it ")
        // }
        for (i in 0 until n) {
            if (!killed[i]) {
                print(w[i])
            }
        }
        println()
    }
}

data class Choice(
    val cost: Int,
    val index: Int
) : Comparable<Choice> {

    override fun compareTo(other: Choice): Int {
        return this.cost.compareTo(other.cost)
    }

    override fun toString(): String {
        return "cost=$cost + index=$index"
    }
}