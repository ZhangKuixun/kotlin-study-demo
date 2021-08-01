package com.kevin.coroutines5

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking

/**
 * other：Kevin
 * create time：2021/8/1
 * describe：
 * Flow的组合
 *
 * zip：将多个流的内容组合成一个流。
 */
fun main() = runBlocking<Unit> {
    val nums = (1..5).asFlow()
    val strs = flowOf("one", "two", "three", "four", "five")
    nums.zip(strs) { a, b -> "$a->$b" }.collect { println(it) }
    //1->one
    //2->two
    //3->three
    //4->four
    //5->five
}
