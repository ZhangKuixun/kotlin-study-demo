package com.kevin.kotlin

/**
 * other：Kevin
 * create time：2021/11/1
 * describe：
 * 代码块简写
 */

fun main() {
    代码块简写()
    代码块自动返回()
}

fun 代码块简写() {
    var x = 10
    var y = 20
    var max = if (x > y) x else y
    var min = if (x > y) y else x
}

fun 代码块自动返回() {
    var x = 10
    var y = 20
    var min = if (x > y) {
        print("x>y")
        x
    } else {
        print("y>x")
        y
    }
}