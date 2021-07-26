package com.kevin.coroutines2

import kotlinx.coroutines.*


/**
 * other：Kevin
 * create time：2021/7/26
 * describe：
 * 如何关闭资源
 *
 * 使用finally关闭资源
 * join与cancelAndJoin都会等待所有清理动作完成才会继续往下执行。
 *
 */
fun main() = runBlocking {
    val myJob = launch {
        try {
            repeat(100) { i ->
                println("job: sleeping $i")
                delay(500)
            }
        } finally {
            println("执行了finally块")
        }
    }
    delay(1300)
    println("hello world")

    myJob.cancelAndJoin()
    println("welcome")

    //打印：打印三次"job: sleeping 0...2"； "hello world"； "执行了finally块"； "welcome"；
}
/**
 * myJob.cancelAndJoin()取消协程，根据结论，join与cancelAndJoin都会等待所有清理动作完成才会继
 * 续往下执行，"finally {println("执行了finally块")}"这是清理动作，当协程执行完后，会执行finally
 * 块，finally块执行完后，才表示协程真正的完成了执行。
 */