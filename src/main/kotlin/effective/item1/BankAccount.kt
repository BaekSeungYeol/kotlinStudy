package effective.item1

import kotlin.concurrent.thread

class BankAccount {
    var balance = 0.0
        private set

    fun deposit(depositAmount: Double) {
        balance += depositAmount
    }

    @kotlin.jvm.Throws(InsufficientFunds::class)
    fun withdraw(withdrawAmount: Double) {
        if (balance < withdrawAmount) {
            throw InsufficientFunds()
        }
        balance -= withdrawAmount
    }
}

class InsufficientFunds : Exception()

fun main() {
    // val account = BankAccount()
    // println(account.balance)
    //
    // account.deposit(100.0)
    // println(account.balance)
    //
    // account.withdraw(50.0)
    // println(account.balance)

    val lock = Any()
    var num = 0
    for (i in 1..1000) {
        thread {
            Thread.sleep(10)
            synchronized(lock) {
                num += 1
            }
        }
    }
    Thread.sleep(1000)
    println(num)
}

// suspend fun main() {
//     var num = 0
//     coroutineScope {
//         for(i in 1..1000) {
//             launch {
//                 delay(10)
//                 num+=1
//             }
//         }
//     }
//     println(num)
// }