package com.kotlinplayground.classes

// class with constructor (primary, secondary)
class Person(
    val name: String = "",
    val age: Int = 0
    ) {

    var email : String = ""
    var nameLength : Int = 0
    init {
        println("Inside Init Block")
        nameLength = name.length
    }
    constructor(
        _email: String,
        _name: String = "",
        _age: Int = 0
    ) : this(_name, _age) {
        email = _email
    }

    fun action() {
        println("he is walking")
    }
}

fun main() {
//    // new 없어도 동작함
//    val person = Person("Hosan", 31)
//    person.action()
//    println("Name : ${person.name} and the age is ${person.age}")
//
//    val person1 = Person()
//    person1.action()
//    println("Name : ${person1.name} and the age is ${person1.age}")

    val person2 = Person(_email = "abc@gmail.com", "Byonho", 31)
    println("Person2 email is ${person2.email} " +
            "and his name is ${person2.name} " +
            "and the age is ${person2.age} " +
            "and the name length is ${person2.nameLength}")
}
