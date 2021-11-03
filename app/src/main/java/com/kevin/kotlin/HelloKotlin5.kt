package com.kevin.kotlin

import java.util.*

/**
 * other：Kevin
 * create time：2021/11/1
 * describe：
 * 类型转换
 */

fun main() {
    println(convert2Uppercase("test"))
}

// 注意：Kotlin的Any和java的Object不是一回事，不是同一种语言
fun convert2Uppercase(str: Any): String? {
    if (str is String) {
        // 不用再类型转换
        str.toUpperCase(Locale.getDefault())
    }
    return null
}