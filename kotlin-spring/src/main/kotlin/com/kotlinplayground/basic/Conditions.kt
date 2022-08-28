package com.kotlinplayground.basic

fun main() {

// if-else,
// when
    var name = "Brice"
    name = "Sendkite"
    val result =  if (name.length == 5) {
        println("Name is Five Characters")
        name // return 생략 가능
    } else {
        println("Name is not Five Characters")
        name
    }

    println("result: $result")

    // 1:gold, 2:silver, 3:bronze
    var position = 1
    val medal1 = if (position == 1) {
        "GOLD"
    } else if (position == 2) {
        "SILVER"
    } else if (position == 3) {
        "BRONZE"
    } else {
        "No medal"
    }
    println(medal1)

// when
    position = 2
    val medal2 = when (position) {
        1 -> "GOLD"
        2 -> "SILVER"
        3 -> "BRONZE"
        else -> "No medal"
    }
    println(medal2)
}