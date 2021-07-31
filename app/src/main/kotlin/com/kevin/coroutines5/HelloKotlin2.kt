package com.kevin.coroutines5

/**
 * other：Kevin
 * create time：2021/7/31
 * describe：
 * 如何返回多个通过异步计算的结果值？
 * 1).使用集合
 * 2).序列（Sequence）：阻塞主线程，不是一次性返回全部计算结果，计算完一个，就返回一个。
 */

/**
 * SequenceScope.yield：yield意思是生成或屈服。
 * 向正在构建的Iterator生成一个值，并挂起，直到请求下一个值。
 */
private fun myMethod(): Sequence<Int> = sequence {
    for (i in 100..105) {
        Thread.sleep(1000)
        yield(i)
        //100
        //101
        //102
        //103
        //104
        //105
    }
}

fun main() {
    myMethod().forEach { println(it) }
}