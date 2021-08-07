package com.kevin.coroutines3

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 * other：Kevin
 * create time：2021/7/27
 * describe：
 * 使用async结构化并发程序开发
 */
private suspend fun intValue1(): Int {
    delay(2000)
    return 15
}

private suspend fun intValue2(): Int {
    delay(3000)
    return 20
}

private suspend fun intSum(): Int = coroutineScope {
    val value1 = async { intValue1() }
    val value2 = async { intValue2() }
    value1.await() + value2.await()
}

fun main() = runBlocking {
    val elapsedTime = measureTimeMillis {
        println(intSum())
    }
    println(elapsedTime)
    //打印：3秒后打印"35"、"3052"
}
/**
 * 分析：把挂起函数intValue1()写入一个普通的函数intValue1Async()中，就可以就可以在任何地方使用
 * 挂起函数了，但是intValue1Async.await()必须要用在协程里，因为await函数是一个挂起函数。
 */