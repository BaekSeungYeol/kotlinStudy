import factorymethod.Ship

interface ShipFactory {

    fun orderShip(name: String, email: String): Ship {
        validate(name,email)
        prepareFor(name)
        val ship = createShip()
        sendEmailTo(email, ship)
        return ship
    }

    fun validate(name: String, email: String) {
        println("validate")
    }
    fun prepareFor(name: String) {
        println("$name 준비중 입니다.")
    }
    fun createShip(): Ship
    fun sendEmailTo(email: String, ship: Ship) {
        println("$ship 이 $email 을 보냅니다.")
    }
}
