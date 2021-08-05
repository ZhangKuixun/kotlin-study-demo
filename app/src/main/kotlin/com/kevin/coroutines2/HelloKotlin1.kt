package com.kevin.coroutines2

import kotlinx.coroutines.*


/**
 * other：Kevin
 * create time：2021/7/26
 * describe：
 * 协程的取消与超时
 * 取消和停止线程概念类似。
 */
fun main() = runBlocking {
    val myJob = GlobalScope.launch {
        repeat(200) { i ->
            println("hello $i")
            delay(500)
        }
    }

    delay(1100)
    println("hello world")

//    myJob.cancel(CancellationException("just a try"))
//    myJob.join()

    myJob.cancelAndJoin()

    println("welcome")
    //打印：每隔500毫秒打印，打印三次"hello 0...2"；到达1100毫秒 "hello world"； "welcome"；
}
/**
 * public fun cancel(cause: CancellationException? = null)
 * 文档：取消job，还可以写取消的原因。cause可以用来指定错误消息，或者提供详细的错误原因。
 * CancellationException：最终是java的 IllegalStateException。
 *
 * public suspend fun Job.cancelAndJoin()
 * 文档：取消job，并且挂起调用的协程直到取消的job完成。
 *
 * cancel()和join()为什么必须成对出现，因为调用了cancel，协程不是立刻停止执行了，中间总会有间隔
 * 时间，调用join的目的是要等待要取消的job真正的完成。
 *
 *
 * 分析能取消的原因：
 * 当调用cancelAndJoin时，把isActive变成了false，相当于取消了协程，delay本来是等待的状态，delay
 * 等待结束，会判断isActive，此时isActive为false，就执行job的取消方法，把job取消了。delay也会抛
 * 出异常，当然不会抛到客户端。
 */