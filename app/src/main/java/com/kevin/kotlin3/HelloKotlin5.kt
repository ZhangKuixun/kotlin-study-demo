package com.kevin.kotlin3

/**
 * other：Kevin
 * create time：2021/6/26
 * describe：
 * 练习
 */
class OuterClass5 {
    inner class NestedClass5(str: String) {
        init {
            println(str)
        }
    }
}

fun main() {
    val nestedClass4: OuterClass5.NestedClass5 = OuterClass5().NestedClass5("hello world")
}