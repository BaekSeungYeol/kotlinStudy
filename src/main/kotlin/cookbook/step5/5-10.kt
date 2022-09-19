package cookbook.step5


interface Iterator<out T> {
    operator fun next(): T
    operator fun hasNext(): Boolean
}

data class Player(val name: String)
class Team(
    val name: String,
    val players: MutableList<Player> = mutableListOf()) : Iterable<Player>{
    fun addPlayers(vararg people: Player) = players.addAll(people)

    override fun iterator(): kotlin.collections.Iterator<Player> {
        return players.iterator()
    }
}
fun main() {
    val team = Team("Warriors")
    team.addPlayers(
        Player("Curry"),
        Player("Thompson"),
        Player("Durant"),
        Player("Green"),
        Player("Cousins"),
    )

    for(player in team) {
        println(player)
    }

    println(team.joinToString { it.name })



}