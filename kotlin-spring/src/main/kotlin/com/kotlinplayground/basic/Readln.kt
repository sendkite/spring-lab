package com.kotlinplayground.basic

fun main() {
    // val line = readLine()!! // before Kotlin 1.6
    // 형 추론으로 안되고, 꼭 변환해야함 -> 기본 입력 값은 String 이다.
    val number = readln().toLong() // 10000000000 넘어가면 Long
    println(number)

    // multiple input
    val (a, b, c, d) = readln().split(" ")
    println(a)
    println(b)
    println(c)
    println(d)


}