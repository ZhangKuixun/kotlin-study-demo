package com.kevin.coroutines5

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import java.lang.RuntimeException

/**
 * other：Kevin
 * create time：2021/8/1
 * describe：
 * Flow的完成
 *
 * onCompletion：
 * 文档：
 * 当给定流已经完成或取消，就会调用action。
 *
 * onCompletion中间操作的一个优势在于它有一个可空的Throwable参数，它可用作确定Flow的收集操作是
 * 正常完成还是异常完成。
 */
private fun myMethod(): Flow<Int> = flow {
    emit(1)
    throw RuntimeException()
}

fun main() = runBlocking<Unit> {
    myMethod().onCompletion { cause -> if (cause != null) println("流异常完成") }
        .catch { cause -> println("catch entered") }
        .collect { println(it) }
    //1
    //Flow Completed Exceptionally
    //catch entered
}