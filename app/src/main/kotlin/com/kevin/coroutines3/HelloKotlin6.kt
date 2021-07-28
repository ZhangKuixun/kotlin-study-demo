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
 * 执行到value1，value1是一个async异步函数，执行到函数体里面，等待20秒，接着执行到value2，执行到value2
 * 的函数体里，线程先睡2秒，然后抛出异常，此时value1还在等待。运行代码，2秒后value2抛出异常，value1也不
 * 等待了，直接进入finally，调用函数的地方也会进入finally。

 * 小结：
 * 子协程取消，会沿着协程的层次关系向上传播，直到父协程及调用父协程的代码也取消或者抛出异常；
 * 挂起函数中的两个协程，自己取消，兄弟协程也会取消。
 */