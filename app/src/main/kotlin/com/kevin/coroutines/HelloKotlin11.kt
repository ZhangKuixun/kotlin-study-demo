package com.kevin.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * other：Kevin
 * create time：2021/7/26
 * describe：
 * 挂起函数（suspend function）
 *
 * 被suspend关键字修饰的函数，叫做挂起函数。
 *
 * 挂起函数只能在协程或另外一个挂起函数中使用。(重点)
 */
fun main() {
    runBlocking {
        launch {
            world()
        }
    }
}

suspend fun hello() {
    delay(4000)
    println("hello world")
}

suspend fun world() {
    hello()
}