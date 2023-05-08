package inaction.appendix

sealed interface Polygon

class Rectangle() : Polygon

class Triangle() : Polygon

fun draw(polygon: Polygon) = when(polygon) {
    is Rectangle -> 2
    is Triangle -> 1
}