package com.kevin.coroutines4

import kotlinx.coroutines.*
import java.util.concurrent.Executors
import kotlin.coroutines.CoroutineContext

/**
 * other：Kevin
 * create time：2021/7/28
 * describe：
 * 协程上下文与分发器（Coroutine Context与Dispatcher）
 *
 *概念：
 * 1.协程总是会在某个上下文中执行，这个上下文是由CoroutineContext类型的实例来表示，该实例是由
 * kotlin标准库来定义的。
 * 2.协程上下文本质是各种元素构成的一个集合，其中，主要元素包括协程的Job，以及分发器。
 * 3.分发器，主要功能是确定由哪个线程来执行我们所指定的协程代码。
 * 4.协程上下文包含了一个协程分发器（CoroutineDispatcher），协程分发器确定由哪个线程或线程池去执行
 * 指定的协程。协程分发器可以将协程的执行限制到一个具体指定的线程，也可以将协程分发到一个线程池中
 * 执行，由线程池中的某个线程来执行我们所指定的协程，还可以不加任何限制的去执行指定的协程代码。这
 * 种情况下，不能确定指定的协程代码由哪个线程或线程池来执行，需要根据程序的实际情况确定，这种方式的
 * 协程分发器在一般的开发中很少使用，只用在一些特殊的情况下。
 *
 * CoroutineDispatcher：
 * 文档：
 * 是一个抽象类，所有协程分发器的父类。
 * 下面的标准实现是由"kotlinx.coroutines"做为Dispatchers属性提供：
 * Dispatchers.Default：协程构造器没有dispatcher和ContinuationInterceptor，它使用共享的后台线程池。
 * Dispatchers.Main：
 * Dispatchers.IO：
 * Dispatchers.Unconfined：协程分发器，没有把协程限制到具体的线程（很少用）
 *
 * Dispatchers：
 * Default、Main、Unconfined、IO都是协程分发器，做为Dispatchers的属性，都继承了CoroutineDispatcher，
 * 写协程分发器时，可以直接写Dispatchers.Default...，指定的协程分发器是什么，协程的逻辑代码就会运行在
 * 指定的线程中。
 *
 * 所有的协程构建器（coroutine builder）,如：launch和async，都会接收一个有默认值的参数CoroutineContext，
 * 该参数可以指定新协程所运行的分发器和其他上下文元素。
 *
 *
 * CoroutineContext和CoroutineDispatcher的关系：launch和async的第一个参数是CoroutineContext，
 * 可以给这个参数赋Dispatchers中的属性，Dispatchers的属性都继承CoroutineDispatcher，CoroutineDispatcher
 * 最终都会继承CoroutineContext。
 * 比如：Dispatchers.Unconfined-->Unconfined: CoroutineDispatcher
 * -->class CoroutineDispatcher : ..., ContinuationInterceptor
 * -->interface ContinuationInterceptor : CoroutineContext.Element
 * -->interface Element : CoroutineContext。
 */
fun main() = runBlocking<Unit> {
    launch {
        println("no params, thread:${Thread.currentThread().name}")
    }
    launch(Dispatchers.Unconfined) {
        println("Dispatchers.Unconfined, thread:${Thread.currentThread().name}")
    }
    launch(Dispatchers.Default) {
        println("Dispatchers.Default, thread:${Thread.currentThread().name}")
    }
//    launch(Executors.newSingleThreadExecutor().asCoroutineDispatcher()) {
    val thread = Executors.newSingleThreadExecutor().asCoroutineDispatcher()
    launch( ) {
        println("single thread executor, thread:${Thread.currentThread().name}")
        thread.close()
    }
    //打印：都会打印，打印顺序是随机的，并且程序一直在执行。

    GlobalScope.launch {
        println("GlobalScope.launch, thread:${Thread.currentThread().name}")
    }
}
/**
 * 分析：
 * 1.
 * launch {
 *     println("no params, thread:${Thread.currentThread().name}")
 * }
 * 如果用launch来启动协程并且不指定协程分发器，他会继承启动自己的CoroutineScope的上下文与分发器。
 * 对于该示例来说，他会继承runBlocking的上下文，而runBlocking运行在main线程中。
 *
 * 2.
 * launch(Dispatchers.Unconfined) {
 *     println("Dispatchers.Unconfined, thread:${Thread.currentThread().name}")
 * }
 * Dispatchers.Unconfined是一种特殊的协程分发器，它在该示例中也是运行在main线程中，但实际上，
 * 它的运行机制与不指定协程分发器时是完全不同的。后面说原理。（很少用）
 *
 * 3.
 * launch(Dispatchers.Default) {
 *     println("Dispatchers.Default, thread:${Thread.currentThread().name}")
 * }
 * Dispatchers.Default：默认协程分发器，如果协程用GlobalScope启动时，使用这个默认的分发器启动协程，
 * 它会使用一个后台的共享线程池来运行协程代码，所以launch(Dispatchers.Default)等价于GlobalScope.launch{}。
 * 它是由JVM的共享线程池作为支持，默认情况下，线程池的最大并行数是cup的最大核心数，至少是2个线程。
 * 假如，并行数量是x，不会有超过x的任务能够在分发器上并行执行。
 *
 * 4.
 * launch(Executors.newSingleThreadExecutor().asCoroutineDispatcher()) {
 *     println("single thread executor, thread:${Thread.currentThread().name}")
 * }
 * Executors.newSingleThreadExecutor().asCoroutineDispatcher()：创建单线程的线程池执行指定
 * 的协程代码。
 *
 * 最后一个问题：程序无法退出，线程一直处于运行的状态。原因：单线程池导致的。launch启动协程，是先创
 * 建单线程池的线程，再启动的协程，最后没有关闭线程。
 * 在实际开发中，使用专门的线程执行协程代码代价非常高，因此在协程代码执行完后，必须要释放线程资源，释
 * 放的方式：1.使用close方法关闭协程分发器，把线程资源释放；2.把协程分发器存储到一个顶层的变量中，以
 * 便在其他程序中复用。
 */