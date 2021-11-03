package com.kevin.kotlin

/**
 * other：Kevin
 * create time：2021/11/1
 * describe：
 * 字符串转整数
 */

fun main() {
    println(convert2Int("牛逼"))
    字符串乘法("2", "a")
}

fun convert2Int(str: String): Int? {
    return try {// 防止空指针
        str.toInt()
    } catch (e: Exception) {
        null
    }
}

fun 字符串乘法(a: String, b: String) {
    val a2Int = convert2Int(a)
    val b2Int = convert2Int(b)

    if (null != a2Int && null != b2Int) {
        println(a2Int * b2Int)
    } else {
        println("参数为null")
    }
}

fun 字符串乘法1(a: String, b: String) {
    val a2Int = convert2Int(a)
    val b2Int = convert2Int(b)

//        println(a2Int * b2Int)// 报错，两个可为空的Int值相乘报错

    when {
        null == a2Int -> {
            println("参数为null")
        }
        null == b2Int -> {
            println("参数为null")
        }
        else -> {
            println(a2Int * b2Int)
        }
    }
}