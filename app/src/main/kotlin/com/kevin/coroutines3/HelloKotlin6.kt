package com.kevin.coroutines3

import kotlinx.coroutines.*
import java.lang.Exception
import kotlin.system.measureTimeMillis

/**
 * other：Kevin
 * create time：2021/7/27
 * describe：
 * 关于父子协程的异常与取消问题
 * 比如在suspend函数中调用了一些执行语句，其中的一个语句出错了，如何解决？
 */
private suspend fun failureComputation(): Int = coroutineScope {
    val value1 = async<Int> {
        try {
            delay(20000)
            50
        } finally {
            println("value1 was cancelled")
        }
    }

    val value2 = async<Int> {
        Thread.sleep(2000)
        println("value2 throws an exception")
        throw Exception()
    }
    value1.await() + value2.await()
}

fun main() = runBlocking<Unit> {
    try {
        failureComputation()
    } finally {
        println("Computation failed")
    }
    // 打印：2秒后打印"value2 throws an exception"、"value1 was cancelled"、"Computation failed"、
    // 抛出异常。
}
/**
 * 分析：
 * 执行到value1，value1是一个async异步函数，执行到函数体里面，等待90000毫秒；接着执行到value2，
 */