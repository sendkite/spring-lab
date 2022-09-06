package com.kotlinplayground.basic

import java.util.Scanner

fun main() {
    // write your code here
    val scanner = Scanner(System.`in`)
    val num = scanner.nextDouble()
    println(num.toLong())
    overflow()

    //toByte, toShort 두개는 반드시 toInt 로 변환하고 사용할 것
}

fun overflow() {
    val n: Int = 10_000 * 10_000 * 10_000
    println("n is $n")
}
