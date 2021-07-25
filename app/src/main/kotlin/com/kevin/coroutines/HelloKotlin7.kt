package com.kevin.coroutines

import kotlinx.coroutines.*


/**
 * other：Kevin
 * create time：2021/7/25
 * describe：
 *
 * 除去不同的协程构建器所提供的协程作用域（coroutine scope）外，还可以通过coroutineScope builder
 * 来声明自己的作用域，该构造器会创建一个协程作用域，并且会等待所有启动的子协程全部完成后自身才会完成。
 *
 * runBlocking与coroutineScope的区别，coroutineScope在等待所有子协程完成任务时不会阻塞当前所有
 * 的线程。
 */
fun main() = runBlocking {
    launch {
        delay(1000)
        println("my job1")
    }
    println("person")

    coroutineScope {
        launch {
            delay(20000)
            println("my job2")
        }
        delay(5000)
        println("hello world")
    }
    println("welcome")
    //打印：person；1秒后打印"my job1"；5秒后打印"hello world"；20秒后打印"my job2"；打印"welcome"；
}
