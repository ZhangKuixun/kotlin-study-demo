package com.kevin.coroutines5

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * other：Kevin
 * create time：2021/8/1
 * describe：
 * Flow Context（Flow 上下文）
 * 用withContext切换Flow发射和终止的上下文。
 */
private fun log(msg: String) = println("[${Thread.currentThread().name}], $msg")
private fun myMethod(): Flow<Int> = flow {
    // FLow的逻辑在另一个协程上下文中执行
    withContext(Dispatchers.Default) {
        for (i in 1..3) {
            Thread.sleep(100)
            emit(i)//IllegalStateException: Flow invariant is violated
        }
    }
}

fun main() = runBlocking {
    myMethod().collect { log("Collected:$it") }
}
/**
 * 分析：
 * 把流的上下文改成了Dispatchers.Default，不再使用collect方法一样的上下文，会报错IllegalStateException。
 *
 */