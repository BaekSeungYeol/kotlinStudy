package inaction.chapter6

interface Processor<T> {
    fun process() : T
}

class NoResultProcessor : Processor<Unit> {
    override fun process() {


    }
}
