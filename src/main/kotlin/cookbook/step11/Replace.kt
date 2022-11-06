package cookbook.step11

fun String.isPalindrome() =
    this.toLowerCase().replace("""[\W+]""".toRegex(), "")
        .let { it == it.reversed()}

