package inaction.chapter11

class Greeter(val greeting: String) {
    operator fun invoke(name: String) {
        println("$greeting, $name!")
    }
}

data class Issue(
    val id: String, val project: String, val type: String,
    val priority: String, val description: String
)

class ImportantIssuesPredicate(val project: String) : (Issue) -> Boolean {
    override fun invoke(issue: Issue): Boolean {
        return issue.project == project && issue.isImportant()
    }

    private fun Issue.isImportant(): Boolean {
        return type == "Bug" &&
            (priority == "Major" || priority == "Critical")
    }
}

class DependencyHandler {
    fun compile(coordinate: String) {
        println("Added dependency on $coordinate")
    }
    operator fun invoke(
        body: DependencyHandler.() -> Unit) {
        body()
    }
}
fun main() {
    val bavarianGreeter = Greeter("Servus")
    bavarianGreeter("Dmitry")

    val i1 = Issue("Idea-154446", "Idea", "Bug", "Major", "Save setings failed")
    val i2 = Issue("Kt-12183", "Kotlin", "Feature", "Normal", "Intention: convert several calls on the same re....")
    val predicate = ImportantIssuesPredicate("Idea")
    for(issue in listOf(i1,i2).filter(predicate)) {
        println(issue.id)
    }

    val dependencies = DependencyHandler()
    dependencies.compile("org.jetbrains.kotlin:kotlin-stdli:1.0.0")
    dependencies {
        compile("org.jetbrains.kotlin:kotlin-reflect:1.0.0")
    }

}