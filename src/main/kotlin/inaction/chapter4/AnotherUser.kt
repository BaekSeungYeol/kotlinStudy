package inaction.chapter4

interface AnotherUser {
    val email: String
    val nickname: String
        get() = email.substringBefore('@')
}

class PrivateUser(override val email: String) : AnotherUser

class SubscribingUser(override val email: String) : AnotherUser {
    override val nickname: String
        get() = email.substringBefore('@')
}

//class FacebookUser(val accountId: Int) : AnotherUser {
//    override val nickname = getFacebookName(accountId)
//}

fun main() {
    println(PrivateUser("test@kotlinlang.org").nickname)
    println(SubscribingUser("test@kotlinlang.org").nickname)

}
