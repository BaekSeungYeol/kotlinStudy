package everything.util

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

object Utils {

    val om = jacksonObjectMapper()

    private val randList = listOf(1, -1)

    private fun getRandomOrder(): Int {
        return randList.shuffled().first()
    }
}