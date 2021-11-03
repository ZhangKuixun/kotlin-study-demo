package com.kevin.kotlin

/**
 * other：Kevin
 * create time：2021/6/16
 * describe：
 * 基本语法详解
 */

fun main() {
    println(convert2Int("1").toString())
    println(普通写法(2, 3))
    println(字符串乘法1("2", "3"))
}

fun 普通写法(a: Int, b: Int): Int {
    return a + b
}

fun 语法糖(a: Int, b: Int) = a + b

fun 不返回值(a: Int, b: Int): Unit {
    print(a + b)
}

fun 字符串模板(a: Int, b: Int) {
    print("$a + $b = ${a + b}")
}

