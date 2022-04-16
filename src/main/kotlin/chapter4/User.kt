package chapter4

open class User(val nickname: String, val isSubscribed: Boolean = false) {
}

class TwitterUser(nickname: String) : User(nickname) {

}
fun main() {
    val hyun = User("현석")
    println(hyun.isSubscribed)

    val gye = User("계영", false)
    println(gye.isSubscribed)

    val hey = User("혜원", isSubscribed = false)
    println(hey.isSubscribed)
}
