package com.kevin.kotlin14

/**
 * other：Kevin
 * create time：2021/7/24
 * describe：
 * 协程（coroutine）
 *
 * 协程的定义
 * 1.协程通过将复杂性放入库中来简化异步编程。程序的逻辑可以在协程中顺序的表达，而底层库会为我们解决异步性。
 * 2.该库可以将用户代码的相关部分包装为回调、订阅事件、在不同线程（或不同的机器）上调度执行，而代码则保持如同顺序执行一样简单。
 *
 * 协程的描述
 * 1.协程像非常轻量级的线程。线程最终是由系统调度的，线程切换或线程阻塞的开销都比较大。
 * 2.协程依赖于线程，但是协程挂起时不需要阻塞线程，几乎是五代价的，协程是由开发者控制的。
 * 所以协程也想是用户态的线程，非常轻量级，一个线程中可以创建任意协程。
 * 3.总而言之：协程可以简化异步编程，可以顺序的表达程序，协程也提供了一种避免阻塞线程并用更廉价、更
 * 可控的操作替代线程阻塞的方法---协程挂起。suspend
 *
 * 协程重要概念
 * 1.CoroutineScope
 * CoroutineScope理解为协程本身，包含了CoroutineContext。
 * 2.CoroutineContext
 * CoroutineContext，协程上下文，是一些元素的集合，主要包括Job和CoroutineDispatcher元素，可以代表一个协程的场景。
 * 3.EmptyCoroutineContext
 * EmptyCoroutineContext表示一个空的协程上下文。
 * 4.CoroutineDispatcher
 * - CoroutineDispatcher，协程调度器，决定协程所在的线程或线程池。它可以指定协程运行于特定的一个线程、
 * 一个线程池或不指定任何线程（这样协程就会运行于当前线程）。
 * - coroutine-core是一个jar包，它的CoroutineDispatcher有三种标准实现：Dispatcher.Default、
 * Dispatcher.IO，Dispatcher.Main和Dispatcher.Unconfined，Unconfined就是不指定线程。
 * - launch函数定义如果不指定CoroutineDispatcher或者没有其他的ContinuationInterceptor，
 * 默认的协程调度器就是Dispatchers.Default，Default是一个协程调度器，其指定的线程为共有的线程池，
 * 线程数量至少为2，最大与CPU数相同。
 * 5.Job&Deferred
 * - Job，任务，封装了协程中需要执行的代码逻辑。Job可以取消并且有简单的生命周期，他有6种状态。
 * @see /图片/job.PNG
 * - Job完成时是没有返回值的，如果需要返回值的话，应该使用Deferred，它是Job的子类。
 * - public interface Deferred<out T>: Job
 * 6.Coroutine builders
 * CoroutineScope.launch函数属于协程构建器Coroutine builders，Kotlin中还有其他几种Builders，负责创建协程。
 * 7.CoroutineScope.launch{}
 * CoroutineScope.launch{}是最常用的Coroutine builders，不阻塞当前线程，在后台创建一个新协程，也可以指定协程调度器。
 * 8.runBlocking{}
 * runBlocking{}是创建一个新的协程同时阻塞当前线程，直到协程结束。这个不应该在协程中使用，主要是为main
 * 函数和测试设计的。
 * 9.withContext{}
 * withContext{}不会创建新的协程，在指定协程上运行挂起代码块，并挂起该协程直到代码块运行完成。
 * 10.async{}
 * CoroutineScope.async{}可以实现与launcher builder一样的效果，不会阻塞当前线程，在后台创建
 * 一个新协程，唯一的区别是它有返回值，因为CoroutineScope.async{}返回的是Deferred类型。
 *
 */
