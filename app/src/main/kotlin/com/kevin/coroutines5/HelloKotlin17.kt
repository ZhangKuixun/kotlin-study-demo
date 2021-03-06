package com.kevin.coroutines5

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * other：Kevin
 * create time：2021/8/1
 * describe：
 * Buffer（缓冲）
 *
 * 作用：
 * buffer主要是对流发射出的流元素，做一个缓存，等终止操作把前一个元素真正的处理完后，终止操作再从
 * 缓存里拿出流元素，减少等待时间。
 */
private fun myMethod(): Flow<Int> = flow {
    for (i in 1..4) {
        delay(100)
        emit(i)
    }
}

fun main() = runBlocking {
    val time = measureTimeMillis {
        myMethod().buffer().collect { value ->
            delay(200)
            println(value)
        }
    }
    println(time)
    //耗时：1020
}
/**
 * 分析：
 * myMethod().buffer()做一个缓冲，不用等待发射的延迟操作。
 *
 * buffer的主要作用是对发射的缓冲，减少等待时间。
 *
 * buffer和flowOn的关系：flowOn也会使用同样的缓冲机制。
 *
 */