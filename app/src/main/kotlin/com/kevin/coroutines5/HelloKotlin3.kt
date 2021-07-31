package com.kevin.coroutines5

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * other：Kevin
 * create time：2021/7/31
 * describe：
 * 如何返回多个通过异步计算的结果值？
 * 1).使用集合：阻塞主线程，一次性返回全部计算结果。
 * 2).序列（Sequence）：阻塞主线程，不是一次性返回全部计算结果，计算完一个，就返回一个。
 * 3).协程：不阻塞主线程的情况下，一次性返回计算结果。
 */
private suspend fun myMethod(): List<String> {
    delay(1000)
    return listOf("hello", "world", "welcome")
}

fun main() = runBlocking {
    myMethod().forEach { println(it) }
    //hello
    //world
    //welcome
}