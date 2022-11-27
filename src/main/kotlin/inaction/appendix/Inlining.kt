package inaction.appendix

import kotlin.math.sqrt

val toplevel: Double
    inline get() = Math.PI

class InlinePropExample(var value: Int) {
    var setOnly: Int
        get() = value
        inline set(v) {
            value = v
        }
    // val backing: Int = 10
    // inline get() = field*1000
}

inline var InlinePropExample.square: Int
get() = value*value
set(v) { value = sqrt(v.toDouble()).toInt() }

fun main() {

}