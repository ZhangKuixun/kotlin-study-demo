package com.kevin.coroutines

import kotlinx.coroutines.*
import kotlin.concurrent.thread


/**
 * other：Kevin
 * create time：2021/7/25
 * describe：
 * 协程是轻量级的
 *
 * 协程可以无限制的创建，用repeat函数
 *
 * 用线程的方式实现repeat
 */
fun main() = runBlocking {
    repeat(10) {
        thread {
            println(it)
            Thread.sleep(1000)
            println("A")
        }
    }
    println("hello world")
    //打印：hello world；1秒后打印10次"A"；
}
/**
 * 如果把repeat的次数改成10000，会报内存溢出，创建线程有上限，和设备的配置有关；
 * 线程的执行比协程慢很多
 */