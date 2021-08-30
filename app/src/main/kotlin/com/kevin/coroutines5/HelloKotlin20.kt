package com.kevin.coroutines5

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import java.lang.Exception

/**
 * other：Kevin
 * create time：2021/8/1
 * describe：
 * 异常（Flow Exception）
 * 捕获收集阶段
 */
private fun myMethod(): Flow<Int> = flow {
    for (i in 1..3) {
        println("emitting $i")
        emit(i)
    }
}

fun main() = runBlocking {
    try {
        myMethod().collect { value ->
            println(value)
            check(value <= 1) {
                "collected $value"
            }
        }
    } catch (e: Exception) {
        println("caught $e")
    }
    //emitting 1
    //1
    //emitting 2
    //2
    //caught java.lang.IllegalStateException: collected 2
}
/**
 * 分析：
 * 第一次执行"emitting 1"，执行到check，1小于等于1，为true，不抛出异常，第二次执行"emitting 2"，
 * 执行到check，2不是小于等于1，为false，抛出异常。
 *
 * check：
 * 文档：
 * 如果value为false，lazyMessage的作为异常的一部分，抛出IllegalStateException。
 */