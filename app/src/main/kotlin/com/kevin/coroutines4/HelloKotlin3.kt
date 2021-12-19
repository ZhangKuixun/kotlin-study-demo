package com.kevin.coroutines4

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

/**
 * other：Kevin
 * create time：2021/7/28
 * describe：
 * 调试协程
 */
private fun log(logMessage: String = "") = println("[${Thread.currentThread().name}] $logMessage")

fun main() = runBlocking<Unit> {
    val a = async {
        log("hello world")
        10
    }
    val b = async {
        log("welcome")
        20
    }
    log("${a.await() * b.await()}")
    //[main] hello world
    //[main] welcome
    //[main] 200

    //[main @coroutine#2] hello world
    //[main @coroutine#3] welcome
    //[main @coroutine#1] 200

}
/**
 * 分析：
 * 只有一个线程，三个协程。
 *
 * 打印协程名称：运行kotlin的配置--VM options加上"-Dkotlinx.coroutines.debug"。
 */
