package com.kevin.coroutines5

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * other：Kevin
 * create time：2021/7/31
 * describe：
 * 只有调用了Flow对象的中止操作，如collect，Flow才会真正执行。
 *
 * 调用了myMethod()后，是立刻返回Flow对象，不会立刻执行里面的代码。
 *
 * Flow：
 * 文档：
 * public interface Flow<out T> {
 * 一种冷异步数据流，按顺序发射值，并正常或异常完成。
 *
 * 中间操作运算符：map、filter、take、zip，不是挂起函数，应用于上游流的函数，并返回下游流。中间操作
 * 符不执行流中的任何代码，只是建立了一个执行操作链，然后迅速返回。这就是冷流特性。
 *
 * 中止操作运算符：collect、single、reduce、toList...，或是launchIn：在给定域中启动流的收集。是挂
 * 起函数，触发所有流的操作。
 *
 * Flow的构建器：
 * flowOf：从一组固定的值创建一个流。
 * asFlow：扩展函数，将各种类型的对象转换为流。
 * flow：调用emit构造任意流。
 * channelFlow：调用send构造任意流。
 */
private fun myMethod(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    println("hello")
    val flow = myMethod()
    println("world")
    //hello
    //world
    //调用Flow的中止操作，如collect，Flow才会真正执行。

    println("调用两次collect：")
    flow.collect { println(it) }
    flow.collect { println(it) }
    //flow调用多少次collect，就执行多少次。
}