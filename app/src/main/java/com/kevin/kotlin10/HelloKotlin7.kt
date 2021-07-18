package com.kevin.kotlin10

/**
 * other：Kevin
 * create time：2021/7/18
 * describe：
 * 扩展属性
 */

val String.firstChar: Char
    get() = this[0]

fun main() {
    println(String::firstChar.get("xyz"))
}
