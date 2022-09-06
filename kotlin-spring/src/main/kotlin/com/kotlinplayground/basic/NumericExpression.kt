package com.kotlinplayground.basic

fun main() {
    // 숫자의 범위
    // bit > byte > short > Int > Long > Float > Double

    // Type coercion 형 강제
    // Long + double
    val num: Long = 100000
    val doubleNum: Double = 1.1
    val sum = num + doubleNum
    println(sum)

    // Long + Int
    val num2: Int = 100
    val longNum2: Long = 1000L
    val result = num2 + longNum2 // 1100, Long
    println(result)

    // Byte + Byte
    val one: Byte = 1
    val two: Byte = 2
    val three = one + two // 3, Int

    // 결론 -> 다른 타입과 연산하려면 마지막에 형변환을 명시한다.
    val five: Byte = 5
    val six = (one + five).toByte() // 6, Byte
}
