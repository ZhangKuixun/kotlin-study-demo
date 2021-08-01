package com.kevin.coroutines5

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * other：Kevin
 * create time：2021/8/1
 * describe：
 * Buffer（缓冲）
 */
private fun myMethod(): Flow<Int> = flow {
    for (i in 1..4) {
        delay(100)
        emit(i)
    }
}

fun main() = runBlocking {
    val time = measureTimeMillis {
        myMethod().collect { value ->
            delay(200)
            println(value)
        }
    }
    println(time)
    //耗时：1238
}
/**
 * 分析：
 * 流元素的发射之前模拟耗时操作，延迟100毫秒，终止操作之前也有延迟200毫秒，在等待期间流元素什么都
 * 不做，等到元素处理完成后，再继续重复处理下一个元素。总耗时1238毫秒。
 *
 * 下一个例子中使用Buffer
 */