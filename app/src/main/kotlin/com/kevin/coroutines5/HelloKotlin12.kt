package com.kevin.coroutines5

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

/**
 * other：Kevin
 * create time：2021/8/1
 * describe：
 * Flow是顺序执行的
 *
 * 对于Flow的收集操作来说，它是运行在调用了终止操作的那个协程上，默认情况下，它是不会启动新的协程，
 * 每个amit的元素值都会由所有的中间操作进行处理，最后再由终止操作处理，本质上就是上游到下游。
 */
fun main() = runBlocking {
    (1..10).asFlow().filter {
        println("Filter:$it")
        it % 2 == 0
    }.map {
        println("Map:$it")
        "Hello:$it"
    }.collect {
        println("Collect:$it")
    }
    //Filter:1
    //Filter:2
    //Map:2
    //Collect:Hello:2
    //Filter:3
    //Filter:4
    //Map:4
    //Collect:Hello:4
    //Filter:5
    //Filter:6
    //Map:6
    //Collect:Hello:6
    //Filter:7
    //Filter:8
    //Map:8
    //Collect:Hello:8
    //Filter:9
    //Filter:10
    //Map:10
    //Collect:Hello:10
}
/**
 * Flow对元素的处理：
 * 1.一个元素接着一个元素的处理；
 * 2.每一个元素先全部处理完全部逻辑，再处理下一个元素。
 */