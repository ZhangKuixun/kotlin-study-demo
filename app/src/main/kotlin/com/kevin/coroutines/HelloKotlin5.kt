package com.kevin.coroutines

import kotlinx.coroutines.*


/**
 * other：Kevin
 * create time：2021/7/25
 * describe：
 * join()
 */
fun main() = runBlocking {
    val myJob: Job = GlobalScope.launch {
        delay(1000)
        println("kotlin coroutines")
    }
    println("hello")

    // 等待协程执行完，再往下走
    myJob.join()

    println("world")
    //打印：hello；1秒后打印"kotlin coroutines"；打印"world"
}
/**
 * join：
 * 文档：
 * public suspend fun join()
 * 挂起协程，直到Job完成。这个调用会正常继续执行，当job出于任何原因完成，
 * 不会抛出异常，并且，job会进入active状态。这个函数还会启动一个协程，如果job是new的状态。
 */