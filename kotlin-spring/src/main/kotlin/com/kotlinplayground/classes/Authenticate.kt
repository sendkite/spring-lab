package com.kotlinplayground.classes

// 자바의 싱글톤과 같이 객체가 한번만 생성되도록 한다.
object Authenticate {
    fun authenticate(userName: String, password: String) {
        println("User Authenticate for userName : $userName")
    }
}

fun main() {
    Authenticate.authenticate("songyeon", "abc")
}