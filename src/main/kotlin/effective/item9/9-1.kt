package effective.item9

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun countCharactersInFile(path: String): Int {
    BufferedReader(FileReader(path)).use { reader -> return reader.lineSequence().sumBy { it.length } }
}

fun countCharactersInFile2(path: String) : Int {
    File(path).useLines { lines -> return lines.sumBy { it.length }}
}