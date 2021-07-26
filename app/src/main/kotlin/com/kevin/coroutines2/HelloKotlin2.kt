package com.kevin.coroutines2

import kotlinx.coroutines.*


/**
 * other：Kevin
 * create time：2021/7/26
 * describe：
 * 协程取消关键技术分析
 *
 * kotlinx.coroutines包下的所有挂起函数都可以取消。
 * 他们会检查协程的取消状态，当前取消时就会抛出CancellationException异常。
 * 但是，如果协程正在处于某个计算过程中，并且没有检查取消状态，那么它就是无法被取消的。
 *
 */
fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (i < 10) {
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: sleeping ${i++}")
                nextPrintTime += 500
            }
        }
    }
    delay(1300)
    println("hello world")

    job.cancelAndJoin()
    println("welcome")
    //打印：打印三次"job: sleeping 0...2"； "hello world"； 打印7次"hello 3...9"； "welcome"；
}