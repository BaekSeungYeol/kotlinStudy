package inaction.chapter7

class Point(val x: Int,
val y: Int) {
    operator fun component1(): Int = x
    operator fun component2() = y
}

data class NameComponents(val name: String, val extension: String)

fun splitFilename(fullName: String) : NameComponents {
    val (name, extension) =  fullName.split('.', limit = 2)
    return NameComponents(name,extension)
}

fun main() {
    val p = Point(10,20)
    val (x,y) = p
    println(x)
    println(y)

    val a = p.component1()
    val b = p.component2()

    val (name, ext) = splitFilename("example.kt")
    println(name)
    println(ext)
}