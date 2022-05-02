package chapter6

fun ignoreNulls(s: String?) {
    val sNotNull : String = s!!
    println(sNotNull.length)
}

fun sendEmailTo (email: String) {

}
fun main() {
    ignoreNulls(null)
    val email: String? = "sample"
    email?.let{
        sendEmailTo(it)
    }

}