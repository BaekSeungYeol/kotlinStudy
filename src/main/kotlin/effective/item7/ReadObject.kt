package effective.item7

fun main() {

    val test = ""
    val result = test.readObject<String>()

    val trueOrNot = when(result) {
        is Success -> true
        is Failure -> false
        else -> false
    }
}

inline fun <reified T> String.readObjectOrNull() : T? {
    return null
}

inline fun <reified T> String.readObject() : Result<T?> {
    if(this.isBlank()) {
        return Failure(JsonParsingException())
    }
    if(this is T) {
        return Success(this)
    }

    throw IllegalArgumentException()
}

sealed class Result<out T>
class Success<out T>(val result: T): Result<T>()
class Failure(val throwable: Throwable) : Result<Nothing>()

class JsonParsingException: Exception()
