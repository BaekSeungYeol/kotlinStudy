package designPattern.factorymethod

import ShipFactory
import factorymethod.Ship

class WhiteShipFactory : ShipFactory{

    override fun createShip(): Ship {
        return WhiteShip("white", "white", "white")
    }
}
