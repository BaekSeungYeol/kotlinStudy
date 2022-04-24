package chapter5

//fun alphabet() : String {
//    val result = StringBuilder()
//    for(letter in 'A' .. 'Z') {
//        result.append(letter)
//    }
//    result.append("\n Now I know the alphabet!")
//    return result.toString()
//}

fun alphabet() : String {
    val stringBuilder = StringBuilder()
    return with(stringBuilder) {
        for(letter in 'A' .. 'Z') {
            this.append(letter)
        }
        append("\n Now I know the alphabet!")
        this.toString()
    }
}

fun alphabet2() = with(StringBuilder()) {
    for(letter in 'A' .. 'Z') {
        append(letter)
    }
    append("\n Now I know the alphabet!")
    toString()
}

fun alphabet3() = StringBuilder().apply {
    for(letter in 'A' .. 'Z') {
        append(letter)
    }
    append("\n Now I know the alphabet!")
}.toString()

fun main() {
    println(alphabet())
}