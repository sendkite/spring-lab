package com.kotlinplayground.basic

fun main() {

    for (i in 1..5) {
        println("i in $i")
        if (i == 3) break
    }

    lable()

    for (i in 1..5) {
        println("i in $i")
        if (i == 3) return
    }

    println("End of the Program!")
}

fun lable() {
    loop@ for (i in 1..5) {
        println("i in label $i")
        //if (i == 3) break@loop
        innerloop@ for (j in 1..5) {
            println("j in lable $j")
            // if(j == 2) break@innerloop
            if (j == 2) continue@loop
        }
    }
}
