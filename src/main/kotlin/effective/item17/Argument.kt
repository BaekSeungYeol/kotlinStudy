package effective.item17

fun main() {
    // val text = (1..10).joinToString(separator = "|")
    // println(text)

    call(before = { print("CALL")})
    call(after = { print("CALL")})
}

fun call(before: ()-> Unit = {}, after: ()->Unit = {}) {
    before()
    print("Middle")
    after()
}
private fun sleep(ms: String) {

}