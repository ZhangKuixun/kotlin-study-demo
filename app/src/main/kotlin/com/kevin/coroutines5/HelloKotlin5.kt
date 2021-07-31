package com.kevin.coroutines5

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * other：Kevin
 * create time：2021/7/31
 * describe：
 * 只有调用了Flow对象的中止操作，如collect，Flow才会真正执行。
 *
 * 调用了myMethod()后，是立刻返回Flow对象，不会立刻执行里面的代码。
 */
private fun myMethod(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    println("hello")
    val flow = myMethod()
    println("world")
    //hello
    //world
    //只有调用了Flow对象的中止操作，如collect，Flow才会真正执行。

    println("调用两次collect：")
    flow.collect { println(it) }
    flow.collect { println(it) }
    //flow调用多少次collect，就执行多少次。
}