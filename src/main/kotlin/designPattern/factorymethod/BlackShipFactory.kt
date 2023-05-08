package designPattern.factorymethod

import ShipFactory
import factorymethod.Ship

class BlackShipFactory: ShipFactory {

    override fun createShip(): Ship {
        return BlackShip("black", "black", "black")
    }
}