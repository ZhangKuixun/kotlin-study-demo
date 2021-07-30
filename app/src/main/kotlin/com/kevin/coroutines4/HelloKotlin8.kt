package com.kevin.coroutines4

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * other：Kevin
 * create time：2021/7/30
 * describe：
 * 协程命名
 *
 * CoroutineName可以对协程命名。
 *
 * CoroutineName：
 * 是一个数据类，开发者可以指定协程的名字，这个名字用在debug模式。
 *
 * -Dkotlinx.coroutines.debug
 *
 */
private fun log(logMessage: String) = println("[${Thread.currentThread().name}] $logMessage")

fun main() = runBlocking(CoroutineName("main")) {
    log("hello")
    val value1 = async(CoroutineName("coroutine1")) {
        delay(800)
        log("coroutine1 log")
        30
    }
    val value2 = async(CoroutineName("coroutine2")) {
        delay(1000)
        log("coroutine2 log")
        5
    }
    log("${value1.await() * value2.await()}")
    //[main @main#1] hello
    //[main @coroutine1#2] coroutine1 log
    //[main @coroutine2#3] coroutine2 log
    //[main @main#1] 150
}