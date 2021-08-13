package com.kevin.coroutines4

import kotlinx.coroutines.*

/**
 * other：Kevin
 * create time：2021/7/30
 * describe：
 * ThreadLocal相关，使用并发并且可以不用上锁，底层就是将一份数据复制成多份，每一份对应于特定的线程，
 * 线程用get方法获取数据时，会在ThreadLocal中判断当前的数据对应的线程是不是同一个线程。
 *
 * 协程不会绑定到固定的线程，数据会发生丢失，怎样解决？
 * asContextElement
 * 用asContextElement，作用是协程在A线程中执行的数据是x，过一会儿，协程又在B线程中执行的数据是y，
 * 过一会儿，协程再次回到A线程中执行，数据又恢复为x。
 *
 * asContextElement：
 * 文档：
 * ThreadLocal的扩展方法，把ThreadLocal包装生成一个新的ThreadContextElement，ThreadContextElement
 * 会给协程维护给定ThreadLocal的给定value，不管实际的执行线程。默认情况下，ThreadLocal.get是作为
 * thread-local变量的一个值，但是value参数能够被覆盖。
 *
 * 请注意：context元素不会追踪thread-local的修改，并且没有相应上下文元素的协程访问thread-local会返回undefined值。
 * 例子：
 * val myThreadLocal = ThreadLocal<String?>()
 * ...
 * println(myThreadLocal.get()) // Prints "null"
 *   launch(Dispatchers.Default + myThreadLocal.asContextElement(value = "foo")) {
 *   println(myThreadLocal.get()) // Prints "foo"
 *   withContext(Dispatchers.Main) {
 *     println(myThreadLocal.get()) // Prints "foo", but it's on UI thread
 *   }
 * }
 * println(myThreadLocal.get()) // Prints "null"
 *
 * 1). context元素不会追踪thread-local的修改：
 * myThreadLocal.set("main")
 * withContext(Dispatchers.Main) {
 *   println(myThreadLocal.get()) // Prints "main"
 *   myThreadLocal.set("UI")
 * }
 * println(myThreadLocal.get()) // Prints "main", not "UI"
 *
 * 2). 使用withContext更新线程对应本地的变量：
 * withContext(myThreadLocal.asContextElement("foo")) {
 *   println(myThreadLocal.get()) // Prints "foo"
 * }
 *
 * 3). 访问thread-local不需要对应的context元素，会出现不确定的值：
 * val tl = ThreadLocal.withInitial { "initial" }
 * runBlocking {
 *   println(tl.get()) // Will print "initial"
 *   // Change context
 *   withContext(tl.asContextElement("modified")) {
 *     println(tl.get()) // Will print "modified"
 *   }
 *   // Context is changed again
 *   println(tl.get()) // <- WARN: 可能打印"modified"或者打印"initial"
 *   修复：runBlocking(tl.asContextElement())
 * }
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
 * 一开始在main线程执行，维护的局部变量的值是hello；然后进入launch，进入launch之后，协程所在的线
 * 程切换到DefaultDispatcher线程，用asContextElement把之前依附于main线程的hello值保存到临时的
 * 上下文中，把DefaultDispatcher线程上下文的局部变量值变成world，launch协程的线程的局部变量值是
 * world，launch协程执行完成后，恢复到main线程；然后恢复main线程之前保存的变量hello，最后打印
 * value是hello。
 */