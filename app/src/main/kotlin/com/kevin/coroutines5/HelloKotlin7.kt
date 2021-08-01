package com.kevin.coroutines5

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

/**
 * other：Kevin
 * create time：2021/7/31
 * describe：
 * Flow的构建器（Flow builder）
 *
 * 1.flow是最经常被使用的一种流构建器。
 * 2.flowOf构建器可用于定义能够发射固定数量值的流。
 * 3.结合、序列、范围...，他们都提供asFlow扩展方法，将自身转换为Flow。
 */
fun main() = runBlocking<Unit> {
    (1..10).asFlow().collect { println(it) }//1...10

    println("-----------")
    flowOf(1, 2, "3").collect { println(it) }//1 2 3
}
/**
 * IntRange.asFlow(): Flow<Int> = flow：这里的flow是unsafeFlow的别名。
 * unsafeFlow：
 * 文档：是一个类似于Flow构建器，不会检查生成的flow的执行上下文，在自己运算符中操作，是受信任的上下文。
 *
 * unsafeFlow(@BuilderInference crossinline block: suspend FlowCollector<T>.() -> Unit)
 * crossinline：
 * 非局部返回（non-local returns）：（重要）
 * 1.在一个方法内部，在方法内部通过一个lambda表达式的返回，直接作为外层方法返回。在一个方法内部执行
 * 一个方法，内部方法有返回值，内部方法的返回值不能表示外层真正的方法的的返回值，想要把内部方法的返
 * 回值作为外部方法的返回值，这就是非局部返回。
 * 2.非局部返回的前提是要求外部的方法是inline。
 * 3.某些情况下，内部方法可以引用外部方法外面的对象或者上下文。
 * crossinline：
 * 被标记的内部方法不允许非局部返回，必须要从外部方法的return语句返回。避免内部方法的返回作为外部方
 * 法的返回，会导致程序错乱的问题。
 *
 * flowOf：
 * 文档：
 * flowOf(vararg elements: T)
 * 通过可变参数创建一个流，例如：flowOf(1, 2, 3)
 * flowOf(value: T)
 * flowOf的重载方法，减少单个值的存储空间。
 */

