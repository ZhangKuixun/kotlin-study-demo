package com.kevin.coroutines2

import kotlinx.coroutines.*

/**
 * other：Kevin
 * create time：2021/7/27
 * describe：
 * 取消的代码块中执行挂起函数
 */
fun main() = runBlocking {
    val myJob = launch {
        try {
            repeat(100) { i ->
                println("job: sleeping $i")
                delay(500)
            }
        } finally {
            withContext(NonCancellable) {
                println("执行了finally块")
                delay(1000)
                println("执行了delay的代码")
            }
        }
    }
    delay(1300)
    println("hello world")

    myJob.cancelAndJoin()
    println("welcome")

    //打印：打印三次"job: sleeping 0...2"； "hello world"； "执行了finally块"； "welcome"；
}
/**
 * 在finally中，执行最后的清理，finally中执行挂起函数（delay），挂起函数后面的代码，没有执行。
 * 说明，协程执行到挂起函数的代码时，协程就已经被取消了。
 *
 * 该示例来说，当我们在协程的finally块中使用了挂起函数时，会出现CancellationException异常，中止程序，
 * 但是不会显式抛出异常，原因在于运行着该代码块的协程已经被取消了，这不会产生什么问题，因为大多数关闭操
 * 作通常都是非阻塞的，比如：取消一个job、关闭网络连接，并不需要使用挂起函数。
 * 如果，需要在一个取消的协程中执行挂起函数，可以将执逻辑放入withContext(NonCancellabe){...}中，
 * 这种结构中，实际使用了withContext函数与NonCancellable上下文，可以规避CancellationException。
 *
 * 用withContext变形：
 * 打印：打印三次"job: sleeping 0...2"；"hello world"；"执行了finally块"；"执行了delay的代码"；"welcome"；
 *
 * public suspend fun <T> withContext(
 *     context: CoroutineContext,
 *     block: suspend CoroutineScope.() -> T
 * ): T {
 * 是一个挂起函数，用给定的context调用指定的挂起块，挂起直到结束并且返回结果。
 *
 * public object NonCancellable : AbstractCoroutineContextElement(Job), Job {
 * 是一个对象，总是active的不可取消的job，是为了withContext函数设计的，防止需要被执行并且不被取消的一个代码块。
 * withContext(NonCancellable) {
 *     // 这个代码块不会被取消
 * }
 */