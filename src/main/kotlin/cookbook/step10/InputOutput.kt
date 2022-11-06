package cookbook.step10

import java.io.File

fun get10LongestWordsInDictionary() =
    File("src/main/kotlin/cookbook/step10/testmemo").useLines { line ->
        line.filter { it.length > 5 }
            .sortedByDescending(String::length)
            .take(5)
            .toList()
    }

fun main() {
    get10LongestWordsInDictionary().forEach { word ->
        println("$word (${word.length})")
    }

    File("src/main/kotlin/cookbook/step10/testmemo").printWriter().use { writer ->
        writer.println("whoKnowsThisWordThisWordisJustSampleForMyTest")
    }

    get10LongestWordsInDictionary().forEach { word ->
        println("$word (${word.length})")
    }



}