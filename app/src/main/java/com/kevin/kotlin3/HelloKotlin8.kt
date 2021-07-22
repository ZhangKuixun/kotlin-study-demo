package com.kevin.kotlin3

/**
 * other：Kevin
 * create time：2021/6/26
 * describe：
 * 外层变量不用申明为final
 * 类似于Java的匿名内部类，Kotlin对象表达式中的代码是可以访问到外层的变量，外层变量不用申明为final。
 */
fun main() {
    var i = 100
    val myObject = object {
        fun myMethod() {
            i++
        }
    }
    myObject.myMethod()
    println(i)
}