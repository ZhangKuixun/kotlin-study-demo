package com.kevin.kotlin10

/**
 * other：Kevin
 * create time：2021/7/18
 * describe：
 * 函数引用：
 * 等价lambda表达式
 */
fun multiplyBy3(x: Int): Int {
    return 3 * x
}

// 支持重载：前提是kotlin能推断出类型。
fun multiplyBy3(x: String): Int {
    return 10
}

fun main() {
    val listOf = listOf(1, 2, 3, 4)
    println(listOf.map(::multiplyBy3))//[3, 6, 9, 12]
    // map方法的参数是一个函数"(T) -> R"，函数接受一个参数返回一个结果，multiplyBy3也是接受一个参数返回一个结果。
    // 方法引用的写法：类名::方法名字、引用的名字::方法名字，如果是包级别的函数 ::方法名字。
    // ::multiplyBy3表示一个函数类型(Int) -> Int的值。

    println("-----------重载")
    val value2 = listOf("a", "b", "c")
    println(value2.map(::multiplyBy3))//[10, 10, 10]
}

// ::multiplyBy3是函数类型"(Int) -> Int"的值
val myReference: (Int) -> Int = ::multiplyBy3

// ::multiplyBy3是函数类型"(String) -> String"的值
val myReference2: (String) -> Int = ::multiplyBy3

// str的函数类型是"String.(Int) -> Char"
var str: String.(Int) -> Char = String::get