package com.kotlinplayground.basic

fun main() {

    val name : String = "Kotlin immutable valuable"
    println(name)

    // mutable valuable
    var age : Int = 31
    println(age)
    age = 32
    println(age)

// Type
    // Long type : Long 생략 가능
    val salary = 30000L
    println(salary)

    // String 그리고 $ sign, multi lines
    val course = "Kotlin is the concise syntax"
    println("course: $course and the course length is ${course.length}")

    val multiline = "ABC \n DEF"
    println(multiline)

    val multiline1 = """
        ABC
        DEF
    """.trimIndent()
    println(multiline1)
}

