package com.kotlinplayground.classes

data class Employee(
    val id: Int,
    val name: String
)

fun main() {

    val employee = Employee(1, "Songyeon")
    val employee2 = Employee(1, "Songyeon")
    println(employee)


    val compareResult = employee.equals(employee2)
    println("They are same: $compareResult")

    val employee3 = employee.copy(name = "Hosan")
    println(employee3)
}