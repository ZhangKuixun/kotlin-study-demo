package com.kevin.kotlin

/**
 * other：Kevin
 * create time：2021/11/1
 * describe：
 * when语法
 */
fun main() {
    println(when语法("hello"))
    println(简化when语法("hello"))
    其他when表达式()
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