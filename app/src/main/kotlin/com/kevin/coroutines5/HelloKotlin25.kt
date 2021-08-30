package com.kevin.coroutines5

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * other：Kevin
 * create time：2021/8/1
 * describe：
 * Flow的完成
 *
 * onCompletion的陷阱：
 * 类似于catch，onCompletion只会看到来自于Flow上游的异常，但是它看不见Flow下游的异常。重点。
 * 上游：在onCompletion之前执行的代码。
 * 下游：在onCompletion之后执行的代码，比如终止操作collect。
 */
private fun myMethod(): Flow<Int> = (1..3).asFlow()

fun main() = runBlocking<Unit> {
    myMethod().onCompletion { cause -> println("Flow Completed with $cause") }
        .collect { value ->
            check(value <= 1) { "collected $value" }
            println(value)
        }
    //1
    //Flow Completed with java.lang.IllegalStateException: collected 2
    //Exception in thread "main" java.lang.IllegalStateException: collected 2
}
/**
 * 分析：
 * 执行collect，检查如果value大于等于1，抛出异常，否则打印出来，collect执行结束后再执行
 * onCompletion，第二次执行时value大于1，抛出异常。
 */