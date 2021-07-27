package com.kevin.coroutines3

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * other：Kevin
 * create time：2021/7/27
 * describe：
 * 挂起函数的组合
 *
 * 两个挂起函数求和，并且计算求和的时间
 */
private suspend fun intValue1(): Int {
    delay(2000)
    return 15
}

private suspend fun intValue2(): Int {
    delay(3000)
    return 20
}

fun main() = runBlocking {
    val elapsedTime = measureTimeMillis {
        println(intValue1() + intValue2())//35
    }
    println(elapsedTime)//5014
    //打印：5秒后打印"35"、"5014"
}
/**
 * measureTimeMillis：内联函数，执行给定的函数块，返回流逝计算函数块的时间，毫秒。
 */