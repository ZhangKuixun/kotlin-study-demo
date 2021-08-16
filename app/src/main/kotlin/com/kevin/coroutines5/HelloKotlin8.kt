package com.kevin.coroutines5

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

/**
 * other：Kevin
 * create time：2021/8/1
 * describe：
 * Flow的中间运算符
 * 中间运算符的思想与Java Stream完全一致，每一个元素从上游一个执行到下游，再执行下一个元素。
 * Flow与Sequence的中间运算符的重要差别：中间运算符的代码块可以调用挂起函数。
 *
 */
private suspend fun myExecution(input: Int): String {
    delay(1000)
    return "output:$input"
}

fun main() = runBlocking {
    (1..10).asFlow()
        .filter { it > 5 }
        .map { input ->
            myExecution(input)
        }
        .collect {
            println(it)
        }
    //打印：每隔一秒打印一个output:5...output:10
}
