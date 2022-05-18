package inaction.chapter4

data class Client(var name: String, val postalCode: Int) {
//    override fun toString(): String {
//        return "Client(name=$name, postalCode = $postalCode"
//    }
//
//    override fun equals(other: Any?) : Boolean {
//        if(other == null || other !is Client) {
//            return false
//        }
//        return name == other.name && postalCode == other.postalCode
//    }
//
//    override fun hashCode() : Int = name.hashCode() * 31 + postalCode
}

fun main() {
    val client = Client("seungYeol", 12345)
    val anotherClient = client.copy()

}
