package designPattern.factorymethod

import factorymethod.Ship

data class WhiteShip(
    override var name: String?,
    override var logo: String?,
    override var color: String?,
): Ship(name,logo,color)