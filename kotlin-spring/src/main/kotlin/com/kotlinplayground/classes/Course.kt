package com.kotlinplayground.classes

// data class
data class Course(
    val id: Int,
    val name: String,
    val author: String,
    val courseCategory: CourseCategory = CourseCategory.DEVELOPMENT
)

// enum
enum class CourseCategory {
    DEVELOPMENT,
    BUSINESS,
    DESIGN,
    MARKETING
}

fun main() {
    val course = Course(1,"Reactive Programming in Modern Java", "sendkite")
    val course2 = Course(2,"Facebook marketing", "John", CourseCategory.MARKETING)
    // @Data와 같아보임
    println(course)
    println(course2)
}