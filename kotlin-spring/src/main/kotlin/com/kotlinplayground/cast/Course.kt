package com.kotlinplayground.cast

import com.kotlinplayground.classes.Course

// 형변환
fun checkType(type: Any) {

    when(type) {
        is Course -> { println(type.copy()) }
        is String -> { println(type.lowercase())
        }
    }

}

fun castNumber(d: Any) {

    when(d) {
        d as Double -> println("Value is double")
    }
}

fun main() {
    val course = Course(1, "Reactive Programming", "Bryce")
    checkType(course)
    checkType("Bryce")

    castNumber(1.0)
    // castNumber(1)

    val number = 1
    val doubleNumber = number.toDouble()
    println(doubleNumber)
}


