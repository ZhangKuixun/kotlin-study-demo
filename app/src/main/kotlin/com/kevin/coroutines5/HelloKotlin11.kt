package com.kevin.coroutines5

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import java.lang.Exception

/**
 * other：Kevin
 * create time：2021/8/1
 * describe：
 * Flow终止操作（Terminal Operation）
 *
 * Flow的终止操作都是挂起函数，终止操作才会真正的开始执行流。
 * 常用终止操作：
 * 1.toList、toSet，转换成集合；
 * 2.只获取第一个元素；
 * 3.reduce，把一些列的值合成单个的值。
 */
fun main() = runBlocking {
    val result = (1..4).asFlow()
        .map { it * it }
        .reduce { a, b -> a + b }
    println(result)//30
}
/**
 * reduce:
 * 文档：
 * 是个挂起函数，从第一个元素开始累积值，并且应用到参数二的函数操作中，累加每一个值。
 *
 */