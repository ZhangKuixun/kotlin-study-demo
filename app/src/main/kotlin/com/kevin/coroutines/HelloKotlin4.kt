package com.kevin.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


/**
 * other：Kevin
 * create time：2021/7/25
 * describe：
 * 把runBlocking赋值给main
 */
fun main() = runBlocking {
    GlobalScope.launch {
        delay(1000)
        println("kotlin coroutines")
    }
    println("hello")

//    delay(2000)

    println("world")
    //打印：hello；1秒后打印"kotlin coroutines"；2秒后打印"world"

    // 更换第二个delay，delay(500)，
    // 打印：hello  0.5秒后打印world

    // 注释第二个delay
    // 打印：hello  world
}
/**
 *
 */