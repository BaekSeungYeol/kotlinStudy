package inaction.chapter8

data class SiteVisit(
    val path: String,
    val duration: Double,
    val os: OS
)

enum class OS{
    WINDOWS, LINUX, MAC, IOS, ANDROID
}

val log = listOf(
    SiteVisit("/", 34.0, OS.WINDOWS),
    SiteVisit("/", 22.0, OS.MAC),
    SiteVisit("/login", 12.0, OS.WINDOWS),
    SiteVisit("/signup", 8.0, OS.IOS),
    SiteVisit("/", 16.3, OS.ANDROID)
)

// fun List<SiteVisit>.averageDurationFor(os: OS)  =  this.filter { it.os == os }.map(SiteVisit::duration).average()

fun List<SiteVisit>.averageDurationFor(predicate: (SiteVisit) -> Boolean) = this.filter(predicate).map(SiteVisit::duration).average()

fun main() {
    val averageWindowsDuration = log
        .filter { it.os == OS.WINDOWS }
        .map(SiteVisit::duration)
        .average()

    println(averageWindowsDuration)

    // println(log.averageDurationFor(OS.WINDOWS))
    // println(log.averageDurationFor(OS.MAC))

    val averageMobileDuration = log
        .filter { it.os in setOf(OS.IOS, OS.ANDROID) }
        .map(SiteVisit::duration)
        .average()

    println(averageMobileDuration)

    log.averageDurationFor { it.os == OS.IOS && it.path == "/signup" }

}