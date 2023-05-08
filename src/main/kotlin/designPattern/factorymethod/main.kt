import designPattern.factorymethod.BlackShip
import designPattern.factorymethod.BlackShipFactory
import designPattern.factorymethod.WhiteShipFactory

fun main() {

    val whiteship = WhiteShipFactory().orderShip("seung", "seung@naver.com")
    println(whiteship)

    val blackship = BlackShipFactory().orderShip("seung", "seung@naver.com")
    println(blackship)

    // test
    // test2

}