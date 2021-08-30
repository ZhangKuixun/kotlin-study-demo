package com.kevin.coroutines5

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * other：Kevin
 * create time：2021/8/1
 * describe：
 * Flow的完成
 *
 * 声明式：
 * onCompletion是中间操作，它在Flow的collect完成后再执行onCompletion。重点。
 */
private fun myMethod(): Flow<Int> = (1..3).asFlow()

fun main() = runBlocking<Unit> {
    myMethod().onCompletion { println("onCompletion") }
        .collect { println(it) }
    //1
    //2
    //3
    //onCompletion
}
/**
 * 分析：
 *
 * onCompletion：
 * 文档：
 * 当给定流已经完成或者取消，就会调用给定的函数"action"。
 *
 */