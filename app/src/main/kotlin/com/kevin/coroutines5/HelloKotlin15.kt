package com.kevin.coroutines5

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking

/**
 * other：Kevin
 * create time：2021/8/1
 * describe：
 * flowOn
 *
 * 必须在同一个上下文中使用Flow的收集和发射，不能用withContext显示的修改上下文对象，应该使用flowOn。
 *
 * flowOn可以让Flow的发射和收集处在不同的上下文中，本质上会改变上下文中的CoroutineDispatcher，并且
 * 为上游的flow创建另一个协程。
 *
 * 注意：flowOn运算符改变了Flow本身默认的顺序性。
 *
 */
private fun log(msg: String) = println("[${Thread.currentThread().name}], $msg")
private fun myMethod(): Flow<Int> = flow {
    for (i in 1..3) {
        Thread.sleep(100)
        log("emit:$i")
        emit(i)
    }
}.flowOn(Dispatchers.Default)

fun main() = runBlocking {
    myMethod().collect { log("collect:$it") }
    //[DefaultDispatcher-worker-1 @coroutine#2], emit:1
    //[main @coroutine#1], collect:1
    //[DefaultDispatcher-worker-1 @coroutine#2], emit:2
    //[main @coroutine#1], collect:2
    //[DefaultDispatcher-worker-1 @coroutine#2], emit:3
    //[main @coroutine#1], collect:3
}
/**
 * 分析：收集操作发生在一个协程中，发射操作发生在另一个协程中（这一点至关重要）。
 */