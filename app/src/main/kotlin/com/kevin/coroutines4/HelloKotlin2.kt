package com.kevin.coroutines4

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * other：Kevin
 * create time：2021/7/28
 * describe：
 * Dispatchers.Unconfined
 */
fun main() = runBlocking<Unit> {
    launch(Dispatchers.Unconfined) {
        println("Dispatchers.Unconfined, thread:${Thread.currentThread().name}")
        delay(300)
        println("Dispatchers.Unconfined, thread:${Thread.currentThread().name}")
    }
    launch {
        println("No params, thread:${Thread.currentThread().name}")
        delay(2000)
        println("No params, thread:${Thread.currentThread().name}")
    }
    // "Dispatchers.Unconfined, thread:main"
    // "No params, thread:main"
    // "Dispatchers.Unconfined, thread:kotlinx.coroutines.DefaultExecutor"
    // "No params, thread:main"
}
/**
 * 分析：
 * 在main线程中启动Dispatchers.Unconfined协程分发器的协程，到了第一个挂起函数delay(300)之后，
 * main线程遇到了第一个挂起函数，main的有效性就结束了；挂起函数delay(300)执行结束后，是由
 * kotlinx.coroutines.DefaultExecutor线程执行挂起函数后面的代码。
 *
 * 小结：
 * 1. Dispatchers.Unconfined协程分发器会在调用者线程中去启动协程，调用者的线程只会持续到第一个
 * 挂起点；
 * 2.当挂起函数结束后，执行后面协程代码的线程，是由之前的挂起函数决定的，意思是挂起函数是由哪个线
 * 程来执行的，挂起函数的代码也会由这个线程继续执行。
 * Dispatchers.Unconfined适用场景：既不会消耗CUP时间，也不会更新任何功效的数据（特定于具体的线程）。
 *
 * Dispatchers.Unconfined是一种高级的机制，特殊情况中使用：协程执行的分发是不需要的，或者会产生
 * 意料之外的副作用，因为协程中的操作必须立刻执行，在日常的代码编写中，几乎不会使用
 * Dispatchers.Uncofined分发器。
 *
 * Unconfined
 * 文档：
 * 不会绑定到任何线程的协程分发器。在当前执行的线程中执行协程初始化，并且让这个线程执行继续，无论挂
 * 起函数是什么，不会强制使用线程的策略。嵌套的协程在分发器中启动的嵌套协程可以避免堆栈溢出。
 *
 * ##事件循环
 * 事件循环是内部的概念，并且不保证顺序执行，只是一个协程的队列，可以在当前线程中执行。
 * 嵌套协程例子：
 * withContext(Dispatchers.Unconfined) {
 *     println(1)
 *     withContext(Dispatchers.Unconfined) {
 *         println(2)
 *     }
 *     println(3)
 * }
 * println("Done")
 * 打印："1 2 3" or "1 3 2"；"Done"。
 * 只会由两个withContext都完成时才会打印"Done"。
 */