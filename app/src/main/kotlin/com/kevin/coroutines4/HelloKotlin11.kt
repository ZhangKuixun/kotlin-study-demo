package com.kevin.coroutines4

import kotlinx.coroutines.*

/**
 * other：Kevin
 * create time：2021/7/30
 * describe：
 * ThreadLocal相关，使用并发并且可以不用上锁，底层就是将一份数据复制成多份，每一份对应于特定的线程，
 * 线程用get方法获取数据时，会在ThreadLocal中判断当前的数据对应的线程是不是同一个线程。
 *
 * 协程不会绑定到固定的线程，数据就会丢失，怎样解决？
 * asContextElement
 * 协程在A线程中执行的数据是x，过一会儿，协程又在B线程中执行，数据是y，过一会儿，协程再次回到A线程中执行，数据是x。
 *
 * asContextElement：
 * 文档：
 * ThreadLocal的扩展方法，把ThreadLocal包装生成一个新的ThreadContextElement，ThreadContextElement
 * 会给协程维护给定ThreadLocal的给定value，不管实际的执行线程。默认情况下，ThreadLocal.get是作为
 * thread-local变量的一个值，但是value参数能够被覆盖。
 *
 * yield：
 * 把当前执行协程的线程让出来，让别的协程执行。
 *
 * -Dkotlinx.coroutines.debug
 */

val threadLocal = ThreadLocal<String>()

fun main() = runBlocking {
    threadLocal.set("hello")
    println("pre main, thread:${Thread.currentThread()}, value:${threadLocal.get()}")

    val job = launch(Dispatchers.Default + threadLocal.asContextElement(value = "world")) {
        println("launch start:${Thread.currentThread()}, value:${threadLocal.get()}")
        yield()
        println("after yield:${Thread.currentThread()}, value:${threadLocal.get()}")
    }
    job.join()
    println("post main, thread:${Thread.currentThread()}, value:${threadLocal.get()}")

    //pre main, thread:Thread[main @coroutine#1,5,main], value:hello
    //launch start:Thread[DefaultDispatcher-worker-1 @coroutine#2,5,main], value:world
    //after yield:Thread[DefaultDispatcher-worker-2 @coroutine#2,5,main], value:world
    //post main, thread:Thread[main @coroutine#1,5,main], value:hello
}
/**
 * 分析：
 * 一开始在main线程执行，main线程就是runBlocking执行的线程，维护的局部变量的值是hello，打印出hello，
 */