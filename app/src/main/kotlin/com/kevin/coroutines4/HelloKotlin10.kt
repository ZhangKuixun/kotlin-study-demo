package com.kevin.coroutines4

import kotlinx.coroutines.*

/**
 * other：Kevin
 * create time：2021/7/30
 * describe：
 * CoroutineScope在组件的生命周期
 * CoroutineScope可以在主对象结束生命周期时，一起把协程取消，主要是把主对象和协程放在同一个作用域中。
 *
 * 创建标准作用域实例的工厂函数CoroutineScope()和MainScope()：
 * CoroutineScope(context: CoroutineContext): CoroutineScope
 * 文档：
 * 针对通用的工厂函数。创建CoroutineScope，把传入的context包装起来。如果给定的context没有包含Job元素，
 * 创建一个默认Job()，这种方式，在任何子协程失败或者取消也会取消其他的子协程，像在coroutineScope块中。
 *
 * MainScope(): CoroutineScope
 * 文档：
 * 基于Android开发，针对于图形界面的工厂函数。生成的函数包含SupervisorJob和Dispatchers.Main的上下文元素。
 *
 */
class Activity : CoroutineScope by CoroutineScope(Dispatchers.Default) {

    fun destroy() {
        cancel()
    }

    fun doSomething() {
        repeat(8) { i ->
            launch {
                delay((i + 1) * 300L)
                println("coroutine $i is finished")
            }
        }
    }
}

fun main() = runBlocking {
    val activity = Activity()
    activity.doSomething()
    println("启动协程")
    delay(1300)
    println("销毁activity")
    activity.destroy()
    //启动协程
    //coroutine 0 is finished
    //coroutine 1 is finished
    //coroutine 2 is finished
    //coroutine 3 is finished
    //销毁activity
}

