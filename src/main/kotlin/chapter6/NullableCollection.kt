package chapter6

//fun addValidNumbers(numbers: List<Int?>) {
//    var sumOfValidNumbers = 0
//    var invalidNumbers = 0
//
//    for(number in numbers) {
//        if(number != null) {
//            sumOfValidNumbers += number
//        } else {
//            invalidNumbers++
//        }
//    }
//
//    println("Sum of valid numbers : $sumOfValidNumbers")
//    println("Invalid numbers: $invalidNumbers")
//}

fun addValidNumbers(numbers: List<Int?>) {
    val validNumbers = numbers.filterNotNull()
    println("Sum of valid numbers : ${validNumbers.sum()}")
    println("Invalid numbers: ${numbers.size - validNumbers.size}")
}