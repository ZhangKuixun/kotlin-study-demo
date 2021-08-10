package com.kevin.coroutines3

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 * other：Kevin
 * create time：2021/7/27
 * describe：
 *
 * async延迟执行：
 * async的第二个参数设置为CoroutineStart.LAZY，就变成了延迟执行，有两个启动协程方式：
 * 1.调用Deferred的await方法，同步执行。
 * 2.调用Job的start方法，异步执行。
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
        val value1 = async(start = CoroutineStart.LAZY) { intValue1() }
        val value2 = async(start = CoroutineStart.LAZY) { intValue2() }

        println("hello world")

        Thread.sleep(6000)

        // 如果协程的启动模式是CoroutineStart.LAZY，把start()方法去掉，只用await启动协程，协程会变成串行。
        value1.start()
//        value2.start()

        val result1 = value1.await()
        val result2 = value2.await()
        println(result1 + result2)//35
    }
    println(elapsedTime)//9030
    // 没有start
    // 打印："hello world"；9秒后打印"35"、"11050"

    // 有start
    // 打印："hello world"；9秒后打印"35"、"9049"
}
/**
 * 分析：
 * 代码走到"val value1 = async(start = CoroutineStart.LAZY) { intValue1() }"，不会执行
 * intValue1()；代码走到"value1.start()"，async函数才会启动，intValue1()才真正执行，并发
 * 执行intValue1()和intValue2()；然后代码走到value1.await()和value2.await()，并发获取
 * value1和value2的值，最后计算值为35，使用的时间=6000+3000+计算的时间。
 *
 * start()：启动一个协程，不会阻塞线程，并发执行。
 *
 */