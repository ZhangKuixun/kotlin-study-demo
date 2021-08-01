package com.kevin.coroutines5

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import java.lang.Exception

/**
 * other：Kevin
 * create time：2021/8/1
 * describe：
 * 异常（Flow Exception）
 * 捕获发射阶段
 */
private fun myMethod(): Flow<String> =
    flow {
        for (i in 1..3) {
            println("emitting $i")
            emit(i)
        }
    }.map { value ->
        check(value <= 1) {
            "crash on $value"
        }
        "string $value"
    }

fun main() = runBlocking {
    try {
        myMethod().collect { println(it) }
    } catch (e: Exception) {
        println("caught $e")
    }
    //emitting 1
    //string 1
    //emitting 2
    //caught java.lang.IllegalStateException: crash on 2
}
/**
 * 分析：
 * 流的构建器执行了两步操作，先发射出来，然后用map映射把整型转成字符串，在map中用check判断发射
 * 出来的值是不是小于等于1，如果小于等于1就返回值，否则抛出抛出异常。
 *
 * check：
 * 如果value为false，lazyMessage的作为异常的一部分，抛出IllegalStateException。
 */