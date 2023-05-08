package effective.item23

fun main() {
}

inline fun <T> Iterable<T>.filter(
    predicate: (T) -> Boolean
): List<T> {
    val result = ArrayList<T>()
    for (element in this) {
        if (predicate(element)) {
            result.add(element)
        }
    }
    return result
}

// fun <T : Comparable<T>> Iterable<T>.sorted() : List<T> {
//     /*..*/
// }

// fun <T, C : MutableCollection<in T>> Iterable<T>.toCollection(destination: C) : C {
//     /*..*/
// }

inline fun <T,R : Any> Iterable<T>.mapNotNull(
    transform: (T) -> R?
): List<R> {
    return mapNotNullTo(ArrayList<R>(), transform)
}
