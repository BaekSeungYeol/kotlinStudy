package inaction.chapter2

import java.util.Random

class Rectangle(private val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }
}

fun createRandomRectangle(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}

fun main() {
    println(createRandomRectangle().isSquare)
}