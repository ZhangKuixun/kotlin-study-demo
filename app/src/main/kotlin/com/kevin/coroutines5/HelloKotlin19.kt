package com.kevin.coroutines5

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * other：Kevin
 * create time：2021/8/1
 * describe：
 * Flow的组合
 *
 * Flatten Flow：打平，把流里面的二维数组数据变成一维数组数据。
 * 比如：Flow<Flow<Int>> -> Flow<Int>
 */
private fun myMethod(i: Int): Flow<String> = flow {
    emit("$i:First")
    delay(500)
    emit("$i:Second")
}

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    (1..3).asFlow()
        .onEach { delay(100) }
        .flatMapConcat { myMethod(it) }
        .collect { value ->
            println("$value at ${System.currentTimeMillis() - startTime} ms")
        }
    //1:First at 132 ms
    //1:Second at 633 ms
    //2:First at 734 ms
    //2:Second at 1235 ms
    //3:First at 1335 ms
    //3:Second at 1836 ms
}
/**
 * 分析：
 * 每次都会发射两次数据出来，最后用一维数组展示。
 */