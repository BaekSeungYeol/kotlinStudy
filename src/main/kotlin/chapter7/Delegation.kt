package chapter7

class Foo {
//    var p: Type by Delegate()

//    private val delegate = Delegate()
//    var p: Type
//    set(value: Type) = delegate.setValue(..., value)
//    get() = delegate.getValue(...)

}

//class Delegate {
//    operator fun getValue() {}
//    operator fun setValue() {}
//}

class Email{}
class Person(val name: String) {
    val emails by lazy { loadEmails(this)}
}
fun loadEmails(person: Person) : List<Email> {
    println("${person.name}의 이메일을 가져옴")
    return listOf()
}

fun main() {
    val p = Person("Alice")
    p.emails
    p.emails
}