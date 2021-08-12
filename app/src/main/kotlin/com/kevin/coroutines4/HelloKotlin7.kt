package com.kevin.coroutines4

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * other：Kevin
 * create time：2021/7/30
 * describe：
 *
 * 对于父子协程来说，父协程总会等待它的所有子协程完成。父协程不用显示追踪自己启动的子线程，也不用调用
 * 子协程的Job.join方法等待子协程完成。
 */
fun main() = runBlocking {
    val request = launch {
        repeat(5) { i ->
            launch {
                delay((i + 1) * 100L)
                println("coroutine $i 执行完毕")
            }
        }
        println("hello")
    }
    request.join()
    println("world")
}
/**
 * 分析：
 * request是父协程，启动了5个子协程，request启动完之后调用一个join，join要等待父协程和它的子协程
 * 都执行完join才会返回，最后打印"world"。
 */