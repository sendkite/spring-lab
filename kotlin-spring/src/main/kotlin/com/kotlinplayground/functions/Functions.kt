package com.kotlinplayground.functions

import java.time.LocalDate

fun main() {

    printName("Songyeon")
    val result = addition(1, 2)
    println("Result is $result")

    printPersonDetails("Sendkite", "sendkite@jocoos.com", LocalDate.parse("2022-08-23"))
    printPersonDetails(dob = LocalDate.parse("2022-08-23"), name = "SeungTek")
}

// Default parameters
fun printPersonDetails(name: String,
                       email: String = "",
                       dob: LocalDate = LocalDate.now()) {
    println("name is $name \n email is $email \n regs is $dob")
}

fun addition(x: Int, y: Int) = x + y

// return 없으면 unit 타입이라 할 수 있다.
fun printName(name: String) : Unit {
    println("Name is : $name")
}
