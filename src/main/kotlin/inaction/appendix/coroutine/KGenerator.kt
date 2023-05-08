// package inaction.appendix.coroutine
//
// fun idMaker() = generate<Int, Unit> {
//     var index = 0
//     while(index < 3)
//         yield(index++)
// }
//
// fun main() {
//     val gen = idMaker()
//     println(gen)
// }