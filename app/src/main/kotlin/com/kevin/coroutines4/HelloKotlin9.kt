package com.kevin.coroutines4

import kotlinx.coroutines.*

/**
 * other：Kevin
 * create time：2021/7/30
 * describe：
 * 想在启动协程的context参数位置，既传入CoroutineName又传入CoroutineContext，怎么做？
 *
 * -Dkotlinx.coroutines.debug
 */
fun main() = runBlocking<Unit> {
    launch(Dispatchers.Default + CoroutineName("hello")) {
        println("thread:${Thread.currentThread().name}")
    }
    //thread:DefaultDispatcher-worker-1
}
/**
 * "+"定义在CoroutineContext：
 * public operator fun plus(context: CoroutineContext): CoroutineContext
 * 文档：
 * 返回一个包含了上下文的元素和另一个上下文的元素，如果两个context元素有相同的key，就会被丢弃。
 */

