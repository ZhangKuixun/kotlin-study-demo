package com.kevin.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * other：Kevin
 * create time：2021/7/26
 * describe：
 * 全局的协程
 * 类似于守护线程（daemon thread）
 * 使用GlobalScope启动的活动协程，并不会保持进程的生命，他们就像是守护线程一样。
 */
fun main() {
    GlobalScope.launch {
        repeat(10) {
            println("I am sleeping $it")
            delay(400)
        }
    }
    Thread.sleep(2000)
    //打印：打印五次"I am sleeping 0...4"
}
/**
 * GlobalScope.launch实际上调用的是CoroutineScope.launch，
 *
 */