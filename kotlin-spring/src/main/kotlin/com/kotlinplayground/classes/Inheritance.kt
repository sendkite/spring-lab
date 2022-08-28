package com.kotlinplayground.classes

// open Modifier 과 Any
// 하나만 상속할 수 있다.
open class User(val name: String) {

    open var isLoggedIn : Boolean = false
    open fun login() {
        println("Inside user Login")
    }

}

class Student(name : String) : User(name) {
    override var isLoggedIn : Boolean = false

    companion object {
        // static
        const val noOfEnrolledCourse = 10
        fun country() = "USA"
    }

    override fun login() {
        println("Inside student Login")
        // 부모 함수 실행
        super.login()
    }
}

class Instructor(name : String) : User(name)

fun main() {
    val student = Student("Hosan")
    println("name is ${student.name}")
    student.isLoggedIn = true
    println("Logged in value is : ${student.isLoggedIn}")

    val country = Student.country()
    println("He come from $country")
    println("noOfEnrolledCourse is ${Student.noOfEnrolledCourse}")

    val instructor = Instructor("Songyeon")
    println("name is ${instructor.name}")
    instructor.login()
}
