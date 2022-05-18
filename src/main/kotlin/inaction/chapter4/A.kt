package inaction.chapter4

class A {
    companion object {
        fun bar() {
            println("Companion object called")
        }
    }
}

fun main() {
    A.bar()
}

