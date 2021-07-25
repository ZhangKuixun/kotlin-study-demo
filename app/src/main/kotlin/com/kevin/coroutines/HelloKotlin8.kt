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
 * repeat(times: Int, action: (Int) -> Unit)：执行给定函数times次
 * 第二个参数：是一个函数类型，函数接收一个Int类型的值，不返回结果。
 * 为什么可以在repeat中用launch，因为launch函数没有显式的使用索引值。
 */
fun main() = runBlocking {
    repeat(10) {
        launch {
            println(it)
            delay(1000)
            println("A")
        }
    }
    println("hello world")
    //打印：hello world；1...9；1秒后打印10次"A"；
}
