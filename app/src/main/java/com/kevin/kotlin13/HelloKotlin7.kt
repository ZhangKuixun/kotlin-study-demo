package com.kevin.kotlin13

/**
 * other：Kevin
 * create time：2021/7/18
 * describe：
 * 扩展属性
 */

// 扩展属性
val String.firstChar: Char
    get() = this[0]

fun main() {
    // 用属性引用的方式使用：
    println(String::firstChar.get("xyz"))
}