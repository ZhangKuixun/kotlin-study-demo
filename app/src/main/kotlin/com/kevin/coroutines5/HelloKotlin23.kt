package com.kevin.coroutines5

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import java.lang.Exception

/**
 * other：Kevin
 * create time：2021/8/1
 * describe：
 * Flow的完成
 *
 * 声明式：
 * onCompletion中间操作会在Flow的collect终止操作完成后，再去执行onCompletion。重点。
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