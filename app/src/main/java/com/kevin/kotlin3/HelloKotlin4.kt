package com.kevin.kotlin3

/**
 * other：Kevin
 * create time：2021/6/26
 * describe：
 * 练习
 */
class OuterClass4 {
    class NestedClass4 {
        init {
            println("NestedClass")
        }
    }
}

fun main() {
    val nestedClass4: OuterClass4.NestedClass4 = OuterClass4.NestedClass4()
}