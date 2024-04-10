package generic

fun main() {

    val fish = Cage<Fish>()
    fish.put(GoldFish())

    val goldFish = Cage<GoldFish>()
    val silverFish = Cage<SilverFish>()

    fish.moveFrom(silverFish)
    fish.moveFrom(goldFish)
}
interface Fish

class GoldFish: Fish
class SilverFish: Fish
class Cage<T> {
    private val animals: MutableList<T> = mutableListOf()

    fun getFirst(): T {
        return animals.first()
    }

    fun put(animal: T) {
        this.animals.add(animal)
    }

    fun moveFrom(otherCage: Cage<out T>) {
        this.animals.addAll(otherCage.animals)
    }

    fun moveTo(otherCage: Cage<T>) {
        otherCage.animals.addAll(this.animals)
    }
}