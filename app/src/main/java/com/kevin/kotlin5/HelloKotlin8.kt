package com.kevin.kotlin5

import java.util.*


/**
 * other：Kevin
 * create time：2021/7/1
 * describe：
 * 练习
 */
fun main() {
    val strings = arrayOf("hello", "world", "jerry", "tom", "okD")

    // 找出数组中的元素，包含字母r的字符串
//    val results = arrayListOf<String>()
//    strings.forEach {
//        if (it.contains("r")) {
//            results.add(it)
//        }
//    }
//    results.forEach { println(it) }

    // 找出数组中的元素，包含字母r的字符串
    strings.filter { it.contains("r") }.forEach { println(it) }

    println("---------------")

    // 找出长度大于四的字符串
    strings.filter { it.length > 4 }.forEach { println(it) }

    println("---------------")

    // 找出以字母d结尾的字符串，并且把所有匹配的字符串转换成大写
    strings.filter { it.endsWith("d", true) }.map { it.toUpperCase(Locale.ROOT) }
        .forEach { println(it) }
}



