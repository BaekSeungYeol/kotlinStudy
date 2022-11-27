package inaction.chapter11

import org.springframework.validation.BeanPropertyBindingResult
import org.springframework.validation.Errors
import org.springframework.validation.Validator
import java.time.LocalDate
import java.time.Period

interface Matcher<T> {
    fun test(value: T)
}

class startWith(val prefix: String) : Matcher<String> {
    override fun test(value: String) {
        if (!value.startsWith(prefix)) throw AssertionError("String $value does not start with $prefix")
    }
}

infix fun <T> T.should(matcher: Matcher<T>) = matcher.test(this)

object start

infix fun String.should(x: start): StartWrapper = StartWrapper(this)

class StartWrapper(val value: String) {
    infix fun with(prefix: String) =
        if (!value.startsWith(prefix))
            throw AssertionError("String does not start with $prefix: $value")
        else
            Unit
}

val Int.days: Period
    get() = Period.ofDays(this)
val Period.ago: LocalDate
    get() = LocalDate.now() - this
val Period.fromNow: LocalDate
    get() = LocalDate.now() + this

fun main() {
    // val s = ""
    // s should startWith("kot")
    // s should start with "kot"
    //
    // println(1.days.ago)
    // println(1.days.fromNow)

    val s = "aa"

    s?.let {
        println("aa")
    }
    println("bb")

    val arr = mutableSetOf<String>()
    arr.add("aa")
    arr.add("bb")

    // val associate = arr.associateWith { it.plus("xx") }
    // println(associate.toString())
    // val mappings = mutableListOf<Int>(1,2,3)
    // val errors = BeanPropertyBindingResult(mappings, "mappings[]")

    val test = "/asdsadd"

    val replace = test.removePrefix("/")
        .replace("/", ".")

    println(replace)
    // val i = test.indexOfLast{ it == SLASH }
    // val removeRange = test.removeRange((0..i))
    // println(i)
    // println(removeRange)

    // val removePrefix = test.removeRange(test.indexOf("/"))
}

// class CollectionMappingValidator : Validator {
//     override fun supports(clazz: Class<*>): Boolean {
//         return CollectionMapping::class.java.isAssignableFrom(clazz)
//     }
//
//     override fun validate(target: Any, errors: Errors) {
//         val mapping = target as CollectionMapping
//         if (!mapping.toPath.startsWith(TOPATH_PREFIX)) {
//             errors.reject(
//                 "mappings[]",
//                 arrayOf(mapping),
//                 "toPath는 $TOPATH_PREFIX 로 시작해야 합니다[${mapping.toPath}]."
//             )
//         }
//
//         if (mapping.type == MappingType.DISPLAY && !mapping.toPath.startsWith(DOCUMENT_ROOT)) {
//             errors.reject(
//                 "mappings[]",
//                 arrayOf(mapping),
//                 "display타입의 toPath는 $DOCUMENT_ROOT 로 시작해야 합니다[${mapping.toPath}]."
//             )
//         }
//
//         if (mapping.toPath.startsWith(TOPATH_PREFIX + "link.url")
//             && mapping.isConstant
//             && (mapping.fromPath.startsWith("http://") || mapping.fromPath.startsWith("https://"))
//         ) {
//             errors.reject(
//                 "mappings[]",
//                 arrayOf(mapping),
//                 "outlink의 url은 http또는 https로 시작해야 합니다[${mapping.fromPath}]."
//             )
//         }
//     }
//
//     companion object {
//         const val TOPATH_PREFIX = "result."
//         const val DOCUMENT_ROOT = TOPATH_PREFIX + "ds[]."
//     }
// }
