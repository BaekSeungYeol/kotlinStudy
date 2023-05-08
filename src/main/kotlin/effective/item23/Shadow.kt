package effective.item23

// class Forest(val name: String) {
//     fun addTree(name: String) {
//
//     }
// }

interface Tree
class Birch: Tree
class Spruce: Tree

/**
 * Wrong Case
 */
// class Forest<T: Tree> {
//     fun <T: Tree> addTree(tree: T) {
//
//     }
// }

class Forest<T: Tree> {
    fun addTree(tree: T) {

    }
}


fun main() {
    val forest = Forest<Birch>()
    forest.addTree(Birch())
    // forest.addTree(Spruce()) // ERROR

}