package com.kevin.coroutines

import kotlinx.coroutines.*


/**
 * other：Kevin
 * create time：2021/7/25
 * describe：
 * runBlocking中直接写launch，launch使用runBlocking的CoroutineScope。
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
 * 每一个协程构建器（包括runBlocking）都会向自己代码块作用域中隐式添加一个CoroutineScope实例，
 * 开发者可以在这个作用域内启动协程，而无需显式将外部协程和内部协程join到一起，因为外部协程会等
 * 待内部所有启动的协程全部完成后才会完成外部协程。
 */