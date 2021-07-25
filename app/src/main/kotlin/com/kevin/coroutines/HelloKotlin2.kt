package com.kevin.coroutines

import kotlin.concurrent.thread

/**
 * other：Kevin
 * create time：2021/7/24
 * describe：
 * 创建线程的写法：
 * thread {} 创建指定的线程，运行指定的代码块
 * public fun thread(
 *     start: Boolean = true,
 *     isDaemon: Boolean = false,
 *     contextClassLoader: ClassLoader? = null,
 *     name: String? = null,
 *     priority: Int = -1,
 *     block: () -> Unit
 * ): Thread {
 *     val thread = object : Thread() {
 *         public override fun run() {
 *             block()
 *         }
 *     ...
 *     return thread
 * }
 * thread是一个函数，有六个参数，前五个参数有默认值，最后一个是函数。
 * start：如果为true，线程立即执行；
 * isDaemon：如果为true，线程会作为一个守护线程去执行，守护线程可以理解为后台线程。当运行的都是
 * 守护线程JVM会退出，不论守护线程是否在运行；
 * contextClassLoader：在当前线程中，要使用的类加载器用于加载类和资源；
 * name：线程的名字；
 * priority：线程的优先级；
 */

fun main() {
    thread {
        Thread.sleep(1000)
        println("kotlin coroutines")
    }

    println("hello")

    Thread.sleep(2000)

    println("world")
    //打印：hello；1秒后打印"kotlin coroutines"；2秒后打印"world"
}