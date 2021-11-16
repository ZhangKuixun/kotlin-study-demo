package com.kevin.kotlin3

/**
 * other：Kevin
 * create time：2021/6/26
 * describe：
 * 嵌套类
 */
class OuterClass {
    private val str: String = "hello world"

    class NestedClass {
        fun nestedMethod() = "welcome"
    }
}

fun main() {
    println(OuterClass.NestedClass().nestedMethod())//welcome
}