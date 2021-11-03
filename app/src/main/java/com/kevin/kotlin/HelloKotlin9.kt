package com.kevin.kotlin

import java.util.*

/**
 * other：Kevin
 * create time：2021/11/2
 * describe：
 * 找出长度大于5的操作
 */
fun main() {
    println(找出长度大于5的操作())
}

fun 找出长度大于5的操作() {
    val array = listOf("hello", "world", "hello world", "goodbye")
    array.filter { it.length > 5 }.map { it.toUpperCase(Locale.ROOT) }.sorted()
        .forEach { println(it) }
}