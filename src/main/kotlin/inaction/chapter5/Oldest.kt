package inaction.chapter5

data class Person(val name: String, val age: Int)

fun findTheOldest(people: List<Person>) {
    var maxAge = 0
    var theOldest : Person? = null
    for(person in people) {
        if(person.age > maxAge) {
            maxAge = person.age
            theOldest = person
        }
    }
    println(theOldest)
}

fun main() {
    val people = listOf(Person("Alice",29), Person("Bob", 31))
    findTheOldest(people)

    println(people.maxByOrNull { it.age } )
    println(people.maxByOrNull { p : Person -> p.age} )
    println(people.maxByOrNull(Person::age))

    println(people.maxByOrNull() {p: Person -> p.age})
    println(people.maxByOrNull {p: Person -> p.age})


    val anotherPeople = listOf(Person("이몽룡", 29), Person("성춘향", 31))
    val names = anotherPeople.joinToString(separator = " ", transform = { p : Person -> p.name})
    println(names)

    println(people.maxByOrNull {p -> p.age})
    println(people.maxByOrNull { it.age })


    val list = listOf(1,2,3,4)
    println(list.filter{ it%2 == 0})

    val people2 = listOf(Person("Alice", 29), Person("Bob", 31))
    println(people2.filter { it.age > 30 })

    val maxAge = people.maxByOrNull(Person::age)!!.age
    people.filter { it.age == maxAge }

    val numbers = mapOf(0 to "zero", 1 to "one")
    println(numbers.mapValues { it.value.toUpperCase() })

    val canBeInClub27 = { p: Person -> p.age <= 27 }
    val people3 = listOf(Person("Alice", 27), Person("Bob", 31))

    println(people3.all(canBeInClub27))
    println(people3.any(canBeInClub27))
    println(people3.count(canBeInClub27))

    println(people3.find(canBeInClub27))
    println(people3.firstOrNull(canBeInClub27))

    val map: Map<Int, List<Person>> = people3.groupBy { it.age }
    println(map[27])
    println(map[31])

    val list2 = listOf("a", "ab", "b")
//    println(list2.groupBy(String::first))

//    people3.asSequence()
//        .map(Person::name)
//        .filter { it.startsWith("A")}
//        .toList()

    listOf(1,2,3,4).asSequence()
        .map { print("map($it"); it * it}
        .filter { print("filter($it)"); it %2 == 0}
        .toList()

    println(listOf(1,2,3,4).asSequence().map { it * it}.find { it > 3})



    val people4 = listOf(Person("Alice", 29), Person("Bob", 31), Person("Charles", 31), Person("Dan", 21))
    println(people4.asSequence().map(Person::name).filter { it.length < 4}.toList())
    println(people4.asSequence().filter { it.name.length < 4}.map(Person::name).toList())

}