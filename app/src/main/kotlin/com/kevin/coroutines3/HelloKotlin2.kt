package com.kevin.coroutines3

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 * other：Kevin
 * create time：2021/7/27
 * describe：
 * async与await实现并发
 *
 * async就像是launch一样，它会开启一个单独的协程，协程是一个轻量级线程，可以与其他协程并发工作。
 *
 * async与launch不同点：
 * 1.launch会返回一个Job，Job不会持有任何结果值，只是一个协程的引用。
 * 2.async会返回一个Deferred，是一个轻量级的非阻塞的future，它代表一个promise，可以在稍后提供一个
 * 结果值。可以在deferred上调用await方法获取最终的结果，Deferred也是一个Job，在需要时也要对其取消。
 */
private suspend fun intValue1(): Int {
    delay(2000)
    return 15
}

private suspend fun intValue2(): Int {
    delay(3000)
    return 20
}

fun main() = runBlocking {
    val elapsedTime = measureTimeMillis {
        val value1: Deferred<Int> = async { intValue1() }
        val value2: Deferred<Int> = async { intValue2() }
        val result1 = value1.await()
        val result2 = value2.await()
        println(result1 + result2)//35
    }
    println(elapsedTime)//3028
    //打印：3秒后打印"35"、"3028"
}
/**
 * 分析：
 * 代码走到"val value1 = async { intValue1() }"，会立即执行intValue1()，因为async的
 * 第二个参数默认是立即执行，value1和value2是并发执行的，接着执行"value1.await()"和
 * "value2.await()"获取结果。
 *
 * await()：
 * 返回协程的结果值，不阻塞线程。
 */