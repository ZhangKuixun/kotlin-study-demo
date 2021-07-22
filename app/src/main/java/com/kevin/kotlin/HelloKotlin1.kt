package com.kevin.kotlin

import java.util.*

/**
 * other：Kevin
 * create time：2021/6/16
 * describe：
 */
fun main() {
    测试Any和转大写(2)
    数组()
    区间()
}

// 注意：Kotlin的Any和java的Object不是一回事，不是同一种语言
fun 测试Any和转大写(str: Any): String? {
    if (str is String) {
        // 不用再类型转换
        str.toUpperCase(Locale.getDefault())
    }
    return null
}

fun 数组() {
    // 遍历每个元素
    var array: IntArray = intArrayOf(1, 2, 3, 4)
    for (item: Int in array) {
        println(item)
    }

    println("------")

    // 索引
    for (i: Int in array.indices) {
        println("array[$i] = ${array[i]}")
    }

    // 元素和下标
    for ((index, value) in array.withIndex()) {
        println("array[$index] = $value")
    }
}


fun when语法(str: String): String {
    return when (str) {
        "hello" -> "HELLO"// 如果args参数小写的hello，就返回一个大写的HELLO
        "word" -> "WORD"
        "hello word" -> "HELLO WORD"
        else -> "other input"
    }
}

fun 简化when语法(str: String): String =
    when (str) {
        "hello" -> "HELLO"
        "word" -> "WORD"
        "hello word" -> "HELLO WORD"
        else -> "other input"
    }

fun 其他when表达式() {
    val a = 6
    var result = when (a) {
        1 -> {
            println("a=1")
            10
        }
        2 -> {
            println("a=2")
            20
        }
        3, 4, 5 -> {
            println("a = 3 or 4 or 5")
            30
        }
        in 1..10 -> {
            println("a is between 6 and 10")
            40
        }
        else -> {
            print("a is other value")
            50
        }
    }
}

fun 区间() {
    val a = 5
    val b = 10
    for (i in a..b) {
        println(i)//5 6 7 8 9 10
    }

    println("--------")

    // 编译报错，不能在for循环中用!in
//    for (i !in a..b) {
//    }

    println("--------")

    for (i in a..b step 2) {
        println(i)//5 7 9
    }

    println("--------")

    for (i in 10 downTo 2 step 4) {
        println(i)//10 6 2
    }
}

fun 找出长度大于5的操作() {
    val array = listOf("hello", "world", "hello world")
    array.filter { it.length > 5 }.map { it.toUpperCase(Locale.ROOT) }.sorted()
        .forEach { println(it) }
}

