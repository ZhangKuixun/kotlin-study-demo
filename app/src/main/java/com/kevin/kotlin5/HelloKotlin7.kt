package com.kevin.kotlin5

import java.lang.StringBuilder
import java.util.regex.Pattern

/**
 * other：Kevin
 * create time：2021/7/1
 * describe：
 * 练习：把string字符串列里面的数字过滤掉
 */
const val s = "he2l9lo7"
fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()
    for (index in 0 until length) {
        val element = get(index)
        if (predicate(element)) {
            sb.append(element)
        }
    }
    return sb.toString()
}

fun main() {
//    val compile = Pattern.compile("[^a-zA-Z]")
//    println(compile.matcher(s).replaceAll(""))

    val filter = s.filter { it.isLetter() }
    println(filter)//hello
}



