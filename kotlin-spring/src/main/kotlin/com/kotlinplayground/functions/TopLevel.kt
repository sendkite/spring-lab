package com.kotlinplayground.functions

const val hello = "Hello World!!!"

fun topLevelFunction() : Int {

    return (0..100).random();
}

fun main() {
    val num = topLevelFunction();
    println("Num is $num")
}