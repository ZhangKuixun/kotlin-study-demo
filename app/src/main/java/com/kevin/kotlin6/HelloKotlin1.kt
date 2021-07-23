package com.kevin.kotlin6

/**
 * other：Kevin
 * create time：2021/7/3
 * describe：
 * lambda表达式返回值
 */
fun main() {
    val string = arrayOf("hello", "world", "lambda")

    // 在默认情况下，lambda表达式中最后一个表达式的值会隐式的作为该lambda表达式的返回值。
    string.filter {
        val mayFilter = it.length > 3
        mayFilter
    }

    // 也可以通过全限定return语法来显示从lambda表达式返回值
    string.filter {
        return@filter it.length > 3
    }
}