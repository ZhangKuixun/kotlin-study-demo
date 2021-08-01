package com.kevin.coroutines5

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/**
 * other：Kevin
 * create time：2021/8/1
 * describe：
 * Flow Context（Flow 上下文）
 *
 * Context Preservation（上下文保留）
 * Flow的收集动作是发生在调用协程的上下文中，和定义FLow的上下文没有关系。
 *
 *
 *-Dkotlinx.coroutines.debug
 */
private fun log(msg: String) = println("[${Thread.currentThread().name}], $msg")
private fun myMethod(): Flow<Int> = flow {
    log("started")

    for (i in 1..3) {
        emit(i)
    }
}

fun main() = runBlocking {
    myMethod().collect { log("Collected:$it") }
    //[main @coroutine#1], started
    //[main @coroutine#1], Collected:1
    //[main @coroutine#1], Collected:2
    //[main @coroutine#1], Collected:3
}
/**
 * 分析：
 * 缺点：阻塞主线程。
 * 协程的出现是为了占用更小的执行粒度和异步执行，当前的Flow的收集动作是发生在主线程的上下文中，
 * myMethod方法是Flow，Flow就在主线程中执行，如果Flow执行逻辑太复杂，就会导致主线程卡死。
 * 解决办法：修改Flow的协程上下文，让Flow在另一个线程中执行。下一个例子演示
 */