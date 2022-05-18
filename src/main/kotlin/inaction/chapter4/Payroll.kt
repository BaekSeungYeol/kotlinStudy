package inaction.chapter4

object Payroll {
    val allEmployees = arrayListOf<String>()
    fun calculateSalary() {
        for (person in allEmployees) {

        }
    }
}

fun main() {
    Payroll.allEmployees.add("me")
    Payroll.calculateSalary()
}
