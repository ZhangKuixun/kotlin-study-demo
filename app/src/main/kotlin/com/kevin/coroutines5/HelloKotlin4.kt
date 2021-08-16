package com.kevin.coroutines5

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * other：Kevin
 * create time：2021/7/31
 * describe：
 * Flow：有多个元素执行完一个就返回一个。
 *
 * 想要返回List<String>类型，一次性返回所有值。
 * 想要返回Flow<String>类型，异步流式的返回结果。
 * Flow类似于Sequence<String>类型，但Sequence是同步的。
 */
private fun myMethod(): Flow<Int> = flow {
    for (i in 1..4) {
        delay(100)//不阻塞
//        Thread.sleep(100)//阻塞
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    launch {
        for (i in 1..4) {
            println("hello $i")
            delay(200)
        }
    }
    myMethod().collect { println(it) }
    // delay(100)
    //hello 1
    //1
    //hello 2
    //2
    //3
    //hello 3
    //4
    //hello 4

    // Thread.sleep(100)
    //1
    //2
    //3
    //4
    //hello 1
    //hello 2
    //hello 3
    //hello 4
}
/**
 * 1.Flow构建器通过flow创建。
 * 2.flow{}里面的代码可以挂起。
 * 3.myMethod方法不需要suspend标识符，用emit发射值。
 * 4.Flow里面的值用collect方法收集。
 *
 *
 *
 */