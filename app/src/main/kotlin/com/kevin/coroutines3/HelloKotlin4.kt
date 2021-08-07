package com.kevin.coroutines3

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 * other：Kevin
 * create time：2021/7/27
 * describe：
 * 异步风格的函数：
 */
private suspend fun intValue1(): Int {
    delay(2000)
    return 15
}

private suspend fun intValue2(): Int {
    delay(3000)
    return 20
}

fun intValue1Async() = GlobalScope.async {
    intValue1()
}

fun intValue2Async() = GlobalScope.async {
    intValue2()
}

fun main() {
    val elapsedTime = measureTimeMillis {
        val intValue1Async = intValue1Async()
        val intValue2Async = intValue2Async()

        // 假如在这行中出现异常，协程停不下来。不要用这种方式使用协程。

        runBlocking {
            println("${intValue1Async.await()}, ${intValue2Async.await()}")
        }
    }
    println(elapsedTime)
    //打印：3秒后打印"15, 20"、"3126"
}
/**
 * 分析：
 * 把挂起函数intValue1()写入一个普通的函数intValue1Async()中，就可以就可以在任何地方使用
 * 挂起函数了，但是intValue1Async.await()必须要用在协程里，因为await函数是一个挂起函数。
 */