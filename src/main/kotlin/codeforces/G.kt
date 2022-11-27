// package codeforces
//
// import java.util.Arrays
//
// fun main() {
//     val n = readln().toInt()
//     val nodes = Array(n) { Node() }
//     (1 until n).forEach { i ->
//         val (a,b) = readln().split(" ").map{it.toInt()-1}
//         nodes[a].adj.add(nodes[b])
//         nodes[b].adj.add(nodes[a])
//     }
//
//     nodes[0].dfs(null,0,0)
//     (1 until 20).forEach { i ->
//         nodes.forEach { nn ->
//             if(nn.lift[i-1] != null) {
//                 nn.lift[i] = nn.lift[i-1]!!.lift[i-1]
//             }
//         }
//     }
//     val nq = readln().toInt()
//     test@ for(qq in 0 until nq) {
//         val qSize = readln().toInt()
//         val query = arrayOfNulls<Node>(qSize)
//         val inputNodes = readln().split(" ").map{it.toInt()-1}
//         for(i in 0 until qSize) {
//             query[i] = nodes[inputNodes[i]]
//             Arrays.sort(query)
//             var missCount = 0
//             for(i in 1 until qSize) {
//                 if(!query[i-1]!!.contains(query[i]!!)) {
//                     missCount++
//                     val lca = query[i-1]!!.LCA(query[i]!!, 19)
//                     if(query[0] != lca && query[0]!!.contains(query[i]!!)) {
//                         println("NO")
//                         continue@test
//                     }
//                 }
//             }
//             println(if(missCount > 1) "NO" else "YES")
//         }
//     }
// }
//
// class Node : Comparable<Node> {
//     var pre: Int = 0
//     var post: Int = 0
//     var depth: Int = 0
//     val adj = mutableListOf<Node>()
//     var lift = arrayOfNulls<Node>(20)
//
//     fun dfs(par: Node?, counter: Int, depth: Int): Int {
//         var curCounter = counter + 1
//         pre = curCounter
//         this.depth = depth
//         lift[0] = par
//         adj.forEach {
//             if(it != par) {
//                 curCounter = it.dfs(this, curCounter, depth + 1)
//             }
//         }
//         post = curCounter
//         return post
//     }
//
//     fun atDepth(d: Int): Node {
//         if (depth == d) return this
//         val goUp = depth - d
//         return lift[Integer.numberOfTrailingZeros(goUp)]!!.atDepth(d)
//     }
//
//     fun LCA(o: Node, maxLift: Int) : Node {
//         var curMaxLift = maxLift
//         if(depth != o.depth) {
//             val targetD = depth.coerceAtMost(o.depth)
//             return atDepth(targetD).LCA(o.atDepth(targetD), curMaxLift)
//         }
//         if(this == o) return this
//         if(this.lift[0] == o.lift[0]) return lift[0]!!
//         while(lift[curMaxLift] == o.lift[curMaxLift]) {
//             curMaxLift--
//         }
//         return lift[curMaxLift]!!.LCA(o.lift[curMaxLift]!!, maxLift)
//     }
//     fun contains(o: Node): Boolean {
//         return pre <= o.pre && post >= o.post
//     }
//     override fun compareTo(other: Node): Int {
//         return pre.compareTo(other.pre)
//     }
// }
// // internal class Node : Comparable<Node?> {
// //     var pre = 0
// //     var post = 0
// //     var depth = 0
// //     var adj = ArrayList<Node>()
// //     var lift = arrayOfNulls<Node>(20)
// //     fun dfs(par: Node, counter: Int, depth: Int): Int {
// //         var counter = counter
// //         pre = counter++
// //         this.depth = depth
// //         lift[0] = par
// //         for (nn in adj) if (nn !== par) counter = nn.dfs(this, counter, depth + 1)
// //         return counter.also { post = it }
// //     }
// //
// //     operator fun contains(o: Node): Boolean {
// //         return pre <= o.pre && post >= o.post
// //     }
// //
// //     override operator fun compareTo(o: Node): Int {
// //         return Integer.compare(pre, o.pre)
// //     }
// //
// //     fun atDepth(d: Int): Node {
// //         if (depth == d) return this
// //         val goUp = depth - d
// //         return lift[Integer.numberOfTrailingZeros(goUp)].atDepth(d)
// //     }
// //
// //     fun LCA(o: Node, maxLift: Int): Node? {
// //         var maxLift = maxLift
// //         if (depth != o.depth) {
// //             val targetD = Math.min(depth, o.depth)
// //             return atDepth(targetD).LCA(o.atDepth(targetD), maxLift)
// //         }
// //         if (this === o) return this
// //         if (lift[0] === o.lift.get(0)) return lift[0]
// //         while (lift[maxLift] === o.lift.get(maxLift)) {
// //             maxLift--
// //         }
// //         return lift[maxLift].LCA(o.lift.get(maxLift), maxLift)
// //     }
// // }