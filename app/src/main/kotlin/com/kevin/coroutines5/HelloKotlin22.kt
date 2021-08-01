package com.kevin.coroutines5

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import java.lang.Exception

/**
 * other：Kevin
 * create time：2021/8/1
 * describe：
 * Flow的完成：
 * 在最后完成的基础上，追加一个执行动作。
 *
 * 两种flow的完成写法：
 * 1.命令式：使用try-finally。
 * 2.声明式。
 *
 *
 * 命令式：
 */
private fun myMethod(): Flow<Int> = (1..3).asFlow()

fun main() = runBlocking<Unit> {
    try {
        myMethod().collect { println(it) }
    } finally {
        println("finally")
    }
    //1
    //2
    //3
    //finally
}