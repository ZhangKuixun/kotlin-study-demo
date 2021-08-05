package com.kevin.coroutines2

import kotlinx.coroutines.*

/**
 * other：Kevin
 * create time：2021/7/27
 * describe：
 * 函数超时 withTimeout
 *
 * 解决函数超时：
 * 1.手工引用协程的Job，启动另一个单独的协程，取消这个协程。
 * 2.使用withTimeout。
 */
fun main() = runBlocking {
    withTimeout(1900) {
        repeat(1000) { i ->
            println("hello, $i")
            delay(400)
        }
    }
    //打印：打印五次"hello, 0...4"；抛出异常TimeoutCancellationException；
}
/**
 * 抛出的异常TimeoutCancellationException是CancellationException的子类。
 *
 * withTimeout(timeMillis: Long, block: suspend CoroutineScope.() -> T)
 * timeMillis：超时的时间，毫秒；
 * block：需要执行的逻辑。
 */