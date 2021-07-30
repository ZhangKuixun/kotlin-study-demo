package com.kevin.coroutines4

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * other：Kevin
 * create time：2021/7/29
 * describe：
 * 父子协程的关系
 *
 * 在一个协程内部用标准的方式（launch、async）启动一个协程，内部的协程会通过
 * CoroutineScope.coroutineContext继承外部协程的上下文，同时，内部协程的Job会成为外部协程
 * Job的一个孩子，内部协程会受到外部协程的影响，父协程被取消执行时，父协程所有的子协程会通过递
 * 归的方式一并取消执行。可以无限嵌套。
 *
 * 特例情况：如果在一个协程内部用GlobalScope启动一个新协程，内部协程不是外部协程的一个孩子，内
 * 部协程的Job没有父Job，它不会绑定到它所启动的父协程范围上，内部的协程就是一个独立的协程。
 *
 * GlobalScope：
 * 文档：
 * 1.GlobalScope实现CoroutineScope接口，是全局的CoroutineScope，不会绑定到任何的Job上。
 * 2.GlobalScope用于启动顶层的协程，顶层的协程是在整个应用的生命周期中操作，而且不会被取消。
 * 3.另一种用法，运行在 Dispatchers.Unconfined，没有任何关联的Job。
 *
 * 开发者写代码时，应该在整个应用上定义CoroutineScope，在GlobalScope实例上非常不建议使用async、launch。
 */
fun main() = runBlocking<Unit> {
    val request = launch {
        GlobalScope.launch {
            println("job1:hello")
            delay(1000)
            println("job1:world")
        }

        launch {
            delay(100)
            println("job2:hello")
            delay(1000)
            println("job2:world")
        }
    }
    delay(500)
    request.cancel()

    delay(1000)
    println("welcome")
    //打印：job1:hello；job2:hello；一秒后打印"job1:world"；"welcome"；
}
/**
 * 分析：
 * request有cancel动作，cancel之后，request里面所有的协程都会被取消，GlobalScope启动的协程除外，
 * 能打印"welcome"，因为"welcome"是在runBlocking里面执行的。
 */