package com.kevin.kotlin

/**
 * other：Kevin
 * create time：2021/11/1
 * describe：
 * 数组
 */

fun main() {
    数组()
}

fun 数组() {
    // 遍历每个元素
    val array: IntArray = intArrayOf(1, 2, 3, 4)
    for (item: Int in array) {
        println(item)
    }

    println("------")

    // 索引
    for (i: Int in array.indices) {
        println("array[$i] = ${array[i]}")
    }

    println("------")

    // 元素和下标
    for ((index, value) in array.withIndex()) {
        println("array[$index] = $value")
    }
}