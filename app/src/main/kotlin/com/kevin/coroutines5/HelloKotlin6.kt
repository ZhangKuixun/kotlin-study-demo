package com.kevin.coroutines5

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

/**
 * other：Kevin
 * create time：2021/7/31
 * describe：
 * Flow的取消
 *
 * Flow的取消实际上与协程的取消是一种协作的关系，Flow没有取消概念，Flow取消完全透明的。
 *
 * Flow的收集操作是可以取消的，前提是Flow在可取消的挂起函数中被挂起，如delay。
 */
private fun myMethod(): Flow<Int> = flow {
    for (i in 1..4) {
        delay(100)
        println("emit:$i")
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    withTimeoutOrNull(280) {
        myMethod().collect { println(it) }
    }
    println("Finished")
    //emit:1
    //1
    //emit:2
    //2
    //Finished
}