package com.kevin.coroutines4

import kotlinx.coroutines.*

/**
 * other：Kevin
 * create time：2021/7/28
 * describe：
 * 线程跳转
 */
private fun log(logMessage: String = "") = println("[${Thread.currentThread().name}] $logMessage")

@ObsoleteCoroutinesApi
fun main() = runBlocking<Unit> {
    newSingleThreadContext("context1").use { ctx1 ->
        newSingleThreadContext("context2").use { ctx2 ->
            runBlocking(ctx1) {
                log("started in context1")

                withContext(ctx2) {
                    log("working in context2")
                }

                log("back to context1")
            }
        }
    }
    //[context1 @coroutine#2] started in context1
    //[context2 @coroutine#2] working in context2
    //[context1 @coroutine#2] back to context1
}
/**
 * 分析：
 * 生成两个线程，线程的上下文是嵌套关系，两个线程拥有自己的协程，会生成两个协程，执行时涉及线程切换。
 * 为什么是两个协程？
 * 线程1(context1)上创建了一个协程(@coroutine#2)，线程2(context2)上创建了协程(@coroutine#2)
 *
 * use：在SingleThreadContext上执行给定的block块，无论是否抛出异常，都会将线程正确的关闭掉。
 */
