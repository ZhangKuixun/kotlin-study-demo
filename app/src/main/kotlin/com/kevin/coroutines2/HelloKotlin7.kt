package com.kevin.coroutines2

import kotlinx.coroutines.*

/**
 * other：Kevin
 * create time：2021/7/27
 * describe：
 * 函数超时 withTimeoutOrNull
 *
 */
fun main() = runBlocking {
    val result = withTimeoutOrNull(1900) {
        repeat(10) { i ->
            println("hello, $i")
            delay(400)
        }
        "hello world"
    }
    println(result)
    //打印：打印五次"hello, 0...4"；"null"；
}
/**
 * 如果在1900毫秒内能执行完withTimeoutOrNull里面的逻辑代码块，就把"hello world"赋给result，
 * 如果没有在1900毫秒内执行完withTimeoutOrNull里面的逻辑代码块，把null赋给result。
 */