package com.kotlinplayground.classes

// Secondary Constructor
class Item() {
    var name : String = ""
    var price: Double = 0.0

    get() {
        println("Inside Getter")
        return field
    }

    set(value) {
        if (value >= 0.0) {
            println("Inside Setter")
            field = value
        } else {
            throw IllegalArgumentException("Negative price is not Allowed!")
        }
    }

    constructor(_name: String) : this() {
        name = _name
    }
}

fun main() {

    val item = Item("Iphone")
    println("Item name is ${item.name}")
    item.name = "IPhone14"
    println("Item name is ${item.name}")
    item.price = 10.0
    println(item.price)
}