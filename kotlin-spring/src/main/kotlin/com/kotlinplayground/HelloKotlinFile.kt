package com.kotlinplayground
import java.util.Scanner

fun main() {

    val n1 = 123
    val ch: Char = n1.toChar()
    println(ch.code) // .code 하지 않으면 unicode 취급..?

    // byte to short convert
    val floatNumber = 10f
    val doubleNumber = 1.0

//    val shortNumber = floatNumber.toShort() // avoid this
//    val byteNumber = doubleNumber.toByte()  // avoid this

    val shortNumber = floatNumber.toInt().toShort() // correct way
    val byteNumber = doubleNumber.toInt().toByte()  // correct way
    println(shortNumber)
    println(byteNumber)

//    String

}