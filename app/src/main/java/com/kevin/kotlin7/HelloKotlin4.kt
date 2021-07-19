package com.kevin.kotlin7

/**
 * other：Kevin
 * create time：2021/7/17
 * describe：
 * kotlin调用java的异常：
 * kotlin调用java抛出非运行时异常，kotlin不用捕获异常。
 *
 */
fun main() {
    val myException = MyException()
//    myException.myMethod()

    println("--------------")
    // 获取Java类
    println(MyException()::class.java)
    println(MyException().javaClass)
}

