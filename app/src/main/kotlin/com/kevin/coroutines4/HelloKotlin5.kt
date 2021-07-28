package com.kevin.coroutines4

import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * other：Kevin
 * create time：2021/7/28
 * describe：
 * Job的使用
 * 如果在协程的代码块中，如何获取Job本身？
 * 协程的Job属于协程上下文（coroutineContext）的一部分：
 * val job: Job? = this.coroutineContext[Job]
 *
 */
fun main() = runBlocking<Unit> {
    val job: Job? = coroutineContext[Job]
    println(job)
    //打印：BlockingCoroutine{Active}@6e5e91e4
}
/**
 * 分析：
 * BlockingCoroutine{Active}@6e5e91e4：BlockingCoroutine是阻塞的协程，{Active}处于活动状态，
 * @6e5e91e4一个Hash值。
 *
 * 为什么能在这里用coroutineContext？
 * coroutineContext是CoroutineScope的变量，runBlocking是一个可阻塞的协程，runBlocking最终
 * 调用BlockingCoroutine，它继承了CoroutineScope，所以可以去使用。
 *
 * CoroutineContext：
 * 文档：
 *
 */
