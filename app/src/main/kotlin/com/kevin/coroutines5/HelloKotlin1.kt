package com.kevin.coroutines5

/**
 * other：Kevin
 * create time：2021/7/31
 * describe：
 *
 * 如何返回多个通过异步计算的结果值？
 * 1).使用集合：阻塞主线程，一次性返回全部计算结果。
 */
private fun myMethod(): List<String> = listOf("hello", "world", "welcome")

fun main() {
    myMethod().forEach { println(it) }
    //hello
    //world
    //welcome
}