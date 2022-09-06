package com.kotlinplayground.basic
import java.util.Scanner

// 629를 입력 받으면 926을 출력하는 프로그램을 구현해라
fun main() {
    val scanner = Scanner(System.`in`)
    val number = scanner.nextInt()
    // 1의 자리
    val one = number % 10
    // 10의 자리
    val ten = (number % 100) / 10
    // 100의 자리
    val hund = number / 100
    println("$one$ten$hund")
}