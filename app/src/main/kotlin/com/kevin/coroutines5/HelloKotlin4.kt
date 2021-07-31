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
 * 如果想要返回List<String>类型，表示只能一次性返回所有值。如果想异步流式的返回值，可以使用
 * Flow<String>类型，类似于Sequence<String>类型，但Sequence是同步计算的。
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
 * 2.位于flow{}构建器的代码可以挂起。
 * 3.myMethod方法不需要使用suspend标识符，值是通过emit函数发射。
 * 4.Flow里面的值通过collect方法收集。
 */