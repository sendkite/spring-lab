package com.kotlinplayground

import com.kotlinplayground.functions.hello
import com.kotlinplayground.functions.topLevelFunction

fun main() {
    // println("Hello Kotlin!")
    val randomNum = topLevelFunction()
    println("RandomNum = $randomNum")
    println(hello)
}

