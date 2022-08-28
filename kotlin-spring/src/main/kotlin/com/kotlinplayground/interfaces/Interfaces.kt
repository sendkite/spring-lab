package com.kotlinplayground.interfaces

import com.kotlinplayground.classes.Course

interface CourseRepository {

    fun getById(id: Int) : Course

    fun save(course : Course) : Int {
        println("course : $course")
        return course.id
    }
}

interface Repository {
    fun getAll() : Any
}

class SqlCourseRepository : CourseRepository, Repository {
    override fun getById(id: Int): Course {
        return Course(id,"Reactive Programming", "Sendkite")
    }

    override fun getAll(): Any {
        return 1
    }
}

interface A {
    fun doSomething() {
        println("do something in A")
    }
}

interface B {
    fun doSomething() {
        println("do something in B")
    }
}

class AB : A, B {
    override fun doSomething() {
        // 인터페이스 함수명이 중복되는 경우 해결법
        super<A>.doSomething()
        super<B>.doSomething()
        println("do something in AB")
    }
}

fun main() {
    val sqlCourseRepository =  SqlCourseRepository()
    val course = sqlCourseRepository.getById(1)
    val savedId = sqlCourseRepository.save(course)
    println("Course is $course")
    println("Course Id is $savedId")

    val ab = AB()
    ab.doSomething()
}