package com.kevin.coroutines2

import kotlinx.coroutines.*

/**
 * other：Kevin
 * create time：2021/7/27
 * describe：
 * 函数超时 withTimeout
 *
 * 我们在使用协程时，执行取消协程，很大一部分原因在于协程的执行时间超时了。可以通过手工引用与协程的Job，
 * 启动另一个单独的协程，取消这个协程，不过Kotlin提供了一个函数来帮我们做到这一点。
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
 * withTimeout(timeMillis: Long, block: suspend CoroutineScope.() -> T)
 * timeMillis：超时的时间，毫秒；
 * block：需要执行的逻辑。
 */