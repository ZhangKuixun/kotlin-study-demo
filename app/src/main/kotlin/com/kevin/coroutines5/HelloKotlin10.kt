package com.kevin.coroutines5

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import java.lang.Exception

/**
 * other：Kevin
 * create time：2021/8/1
 * describe：
 * Flow限定数量的中间操作
 *
 * Flow限定数量的中间操作，只取出流前面的元素，后面的元素不管了。
 * 流就是源源不断的流入执行逻辑中，底层是通过特定的异常限制源源不断的流入执行逻辑中，一旦到达了
 * 设置的触发值，就抛出异常。
 */
private fun myNumbers(): Flow<Int> = flow {
    try {
        emit(1)
        emit(2)
        println("hello world")
        emit(3)
    } catch (e: Exception) {
        println(e)
    } finally {
        println("finally")
    }
}
fun main() = runBlocking {
    myNumbers().take(2).collect { println(it) }
    //1
    //2
    //kotlinx.coroutines.flow.internal.AbortFlowException: Flow was aborted, no more elements needed
    //finally
}
/**
 * take:
 * 文档：
 * 返回一个只包含第一个count元素的流，当count元素被消费之后，原始流就会被取消，如果count是负数，
 * 抛出IllegalArgumentException
 *
 * AbortFlowException：
 * 终止异常，继承kotlinx.coroutines.CancellationException，最终是java.util.concurrent.CancellationException。
 *
 * actual：多模块开发时，公共的模块或独立模块可以使用actual标识。
 *
 */