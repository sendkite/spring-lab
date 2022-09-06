package com.kotlinplayground.basic

fun main() {
    // 나누기 메서드
    println(12.floorDiv(4)) // "/"
    println(12.mod(4)) // "%"

    // 단항 연산자
    println(-(100 + 4))

    /**
     *  연사 우선 순위
     *  1. 괄호 ()
     *  2. 단항 + 또는 -
     *  3. 곱셈, 나눗셈, 계수
     *  4. 더하기 빼기
     * */

    // 1. Assignment Operations
    var a = 3
    a += 2 // 5
    a -= 2 // 3
    a *= 2 // 6
    a /= 2 // 3
    a %= 2 // 1
    println(a)

    // increment and decrement
    var num = 3
    num++
    println(num)
    num--
    println(num)

    // prefix vs postfix
    // prefix 는 변수를 사용하기 전에 변경이 일어난다.
    var num1 = 10
    val num2 = ++num1
    println(num1)  // a = 11
    println(num2)  // b = 11

    var num3 = 10
    val num4 = --num3
    println(num3)  // a = 9
    println(num4)  // b = 9

    // postfix 는 변수 사용후에 변경이 일어난다.
    var a2 = 10
    val b2 = a2++
    println(a2)  // a = 11
    println(b2)  // b = 10

//    1. Parentheses ( (expr) );
//    2. Postfix increment/decrement ( expr++, expr--);
//    3. Unary plus/minus, prefix increment/decrement ( -expr, ++expr, --expr );
//    4. Multiplication, division, and modulus ( *, /, % );
//    5. Addition and subtraction ( +, - );
//    6. Assignment operations ( =, +=, -=, *=, /=, %= ).
    println("===")
    // 복잡한 수식
    val secret1 = -1L
    val x = 10 % 3 + 7 / 2 / 2
    val y = secret1 * x + 3
    print(y - x)
}