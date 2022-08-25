package cookbook.step3

class Customer3(val name: String) {

    override fun equals(other: Any?) : Boolean {
        if(this === other) return true
        val otherCustomer = (other as? Customer) ?: return false
        return this.name == otherCustomer.name
    }
    override fun hashCode() = name.hashCode()
}

