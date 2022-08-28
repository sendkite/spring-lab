package com.kotlinplayground.basic

fun main() {

    /** For Loops
     *
    // for loop with range
    val range = 1..10
    for (i in range) {
        println("i: $i")
    }

    // for loop with reverse range
    val reverseRange = 10 downTo 1
    for (i in reverseRange) {
        println("reverseRange : $i")
    }

    // for loop with step
    for (i in reverseRange step 2) {
        println("reverseRange with skip: $i")
    }*/


    // while
    exploreWhile()
    exploreDoWhile()
}

fun exploreDoWhile() {
    var i = 0
    do {
        println("Value of i is: $i")
        i++
    } while (i < 5)
}

fun exploreWhile() {
    var x = 1
    while (x < 5) {
        println("Value of x is $x")
        x++
    }
}
