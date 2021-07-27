package com.kevin.coroutines2

import kotlinx.coroutines.*


/**
 * other：Kevin
 * create time：2021/7/26
 * describe：
 * 协程取消关键技术分析
 *
 * 让计算中的代码取消：
 * 1.周期性的调用一个挂起函数，该挂起函数会检查取消状态，比如：使用yield函数。
 * 2.显式的检查取消状态。
 */
fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (isActive) {
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: sleeping ${i++}")
                nextPrintTime += 500
            }
        }
    }
    delay(1300)
    println("hello world")

    job.cancelAndJoin()
    println("welcome")
    //打印：打印三次"job: sleeping 0...2"； "hello world"； "welcome"；
}
/**
 * isActive是协程的一个扩展属性，通过CoroutineScope添加的。
 *
 * public val CoroutineScope.isActive
 * 文档：当前Job是active（没有取消或完成就是active），返回true。如果检查一个属性在长时间循环
 * 计算，协程就支持取消。
 *
 * HelloKotlin1.kt的例子能取消的原因是在job中用了delay，delay自身中会用到isActive。
 *
 *
 */