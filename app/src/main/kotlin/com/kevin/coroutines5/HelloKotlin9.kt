package com.kevin.coroutines5

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking

/**
 * other：Kevin
 * create time：2021/8/1
 * describe：
 * Flow的转换操作
 * transform：
 * 文档：
 * 是flow的扩展方法，把transform应用到给定流的每一个值。transform的接收者是FlowCollector，
 * transform是通用的函数，可以转换发射出来的元素，将它忽略或发射多次。
 * 例如：
 * fun Flow<Int>.skipOddAndDuplicateEven(): Flow<Int> = transform { value ->
 *     if (value % 2 == 0) { // Emit only even values, but twice
 *         emit(value)
 *         emit(value)
 *     } // Do nothing if odd
 * }
 * 可以在函数体实现filter、map；emit发射出来任意值。
 * 如果逻辑复杂，使用transform，如果逻辑简单就使用filter、map...
 *
 */
private suspend fun myExecution(input: Int): String {
    delay(1000)
    return "output:$input"
}

fun main() = runBlocking {
    (1..10).asFlow()
        .transform { input ->
            emit("input:$input")
            emit(myExecution(input))
            emit("hello world")
        }
        .collect {
            println(it)
        }
    //打印："input:1"，隔1秒打印"output:1"、"hello world"
    //input:1
    //output:1
    //hello world
    //......
}
