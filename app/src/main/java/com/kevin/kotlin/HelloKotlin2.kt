package com.kevin.kotlin

/**
 * other：Kevin
 * create time：2021/11/1
 * describe：
 * 类型推断
 */

fun main() {
    val a: Int = 1
    val b = 2

    var c: Int
    c = 3

    var d = 3
    d = 4

    /*注释嵌套/*/*/**/*/*/*/

    小范围类型的值禁止付给大范围类型的值()

    修改val()
}

fun 小范围类型的值禁止付给大范围类型的值() {
    var x = 10
    var y: Byte = 20
//        x=y// 报错
    x = y.toInt()

    println(x)//20
}

fun 修改val() {
    val m = intArrayOf(1, 2, 3)
//    m = intArrayOf(4, 5, 3)//报错，不能修改val的值
    m[0] = 4

    for (item in m) {
        println(item)
    }
}