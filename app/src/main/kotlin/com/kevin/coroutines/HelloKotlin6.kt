package com.kevin.coroutines

import kotlinx.coroutines.*


/**
 * other：Kevin
 * create time：2021/7/25
 * describe：
 * runBlocking中写launch，launch使用runBlocking的CoroutineScope。
 */
fun main() = runBlocking {
    launch {
        delay(1000)
        println("kotlin coroutines")
    }
    println("hello")
    //打印：hello；1秒后打印"kotlin coroutines"；
}
/**
 * 小结：
 * 协程构建器都会向自己代码块中隐式添加一个CoroutineScope实例，可以在这个代码块内启动协程，
 * 而无需显式将外部协程和内部协程join到一起，外部协程会等待所有内部协程完成后才会完成外部协程。
 */