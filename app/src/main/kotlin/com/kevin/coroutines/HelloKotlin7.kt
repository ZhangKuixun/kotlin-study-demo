package com.kevin.coroutines

import kotlinx.coroutines.*


/**
 * other：Kevin
 * create time：2021/7/25
 * describe：
 *
 * runBlocking与coroutineScope的区别，coroutineScope在等待所有子协程完成任务时不会阻塞当前线程。
 *
 * 1.runBlocking是普通函数，不是挂起函数；调用它的线程会一直位于runBlocking函数中，直到协程执行完毕。
 * 2.coroutineScope是挂起函数；如果coroutineScope的子协程挂起，coroutineScope函数也会挂起，线程
 * 会回退到coroutineScope之外的上一行代码，并且线程可以做其他一些事情。
 *
 */
fun main() = runBlocking {
    launch {
        delay(1000)
        println("my job1")
    }
    println("person")

    coroutineScope {
        launch {
            delay(20000)
            println("my job2")
        }
        delay(5000)
        println("hello world")
    }
    println("welcome")
    //打印：person；1秒后打印"my job1"；5秒后打印"hello world"；20秒后打印"my job2"；打印"welcome"；
}
/**
 *
 * 分析：
 * 1 除去不同的协程构建器创建的协程作用域外，还可以用coroutineScope构造函数来声明自己的作用域，该构造
 * 器会创建一个协程作用域，并且会等待所有启动的子协程全部完成后自身才会完成。
 * 2 程序进入runBlocking之后，第一行代码是启动协程launch{}，launch{}不阻塞线程，当前线程往下走，打
 * 印"person"，然后执行协程构造函数coroutineScope{}，coroutineScope{}是一个挂起函数，它会等待自己
 * 的所有子协程全部执行完之后，它自己才执行完成。对于当程来说，遇到了coroutineScope{}，当
 * coroutineScope{}没有执行完毕，当前线程不会执行coroutineScope{}的下一行代码，不会打印"welcome"。
 *
 * 这和之前的总结有冲突：coroutineScope在等待所有子协程完成任务时不会阻塞当前线程。
 *
 * 为什么会这样呢？
 * 结论：首先coroutineScope{}是一个挂起函数，等到自己里面所有的子协程完成之后，主代码才会继续往下走。
 * 结合程序分析：对于线程来说，一旦遇到了coroutineScope{}，会把coroutineScope{}里面每一行代码都执行
 * 完后，如果coroutineScope{}里面有挂起函数，也要等到挂起函数执行完，线程就从coroutineScope{}中返回
 * 到外层，外层是runBlocking的执行体。
 * 注意：不是返回到coroutineScope{}下一行的代码而是返回到coroutineScope{}上一行的代码。所以上面的总
 * 结是正确的，coroutineScope不会阻塞线程。如果线程被阻塞，不会打印"my job1"。
 *
 * 当前线程在做什么呢？
 * runBlocking有一个事件循环的概念，因为runBlocking里面，在未来的一段时间可能还有其他会被执行的代码。
 *
 * 事件循环是：EventLoop，等待事件循环，事件的发生。
 *
 */






