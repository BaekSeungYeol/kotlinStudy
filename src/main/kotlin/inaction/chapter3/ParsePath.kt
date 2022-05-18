package inaction.chapter3

fun parsePath(path: String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")

    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")

    println("Dir : $directory, name: $fileName, ext: $extension")
}

fun parsePath2(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if(matchResult != null) {
        val (directory, filename, extension) = matchResult.destructured
        println("Dir: $directory, name: $filename, ext: $extension")
    }
}
fun main() {
    parsePath("/Users/yole/kotlin-book/chapter.adoc")
    parsePath2("/Users/yole/kotlin-book/chapter.adoc")
}