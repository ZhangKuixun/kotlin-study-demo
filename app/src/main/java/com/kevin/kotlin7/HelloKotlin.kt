package com.kevin.kotlin7

/**
 * other：Kevin
 * create time：2021/7/4
 * describe：
 * 解构声明
 */
data class MyResult(var result: String, val status: Int)

// 自己的类要方便一点
fun myMethod(): MyResult {
    return MyResult("success", 1)
}

// Pair是kotlin的一个数据类，扩展性和可读性差
fun myMethod2(): Pair<String, Int> {
    return Pair("success", 2)
}

fun main() {
    val (result, states) = myMethod()
    println(result)
    println(states)
    //success
    //1

    println("-------------")

    val (result2, states2) = myMethod2()
    println(result2)
    println(states2)
    //success
    //2

    println("-------------")

    // map中使用解构声明
    val map = mapOf("a" to "aa", "b" to "bb", "c" to "cc")
    for ((key, value) in map) {
        println("key:$key, value:$value")
    }
    //key:a, value:aa
    //key:b, value:bb
    //key:c, value:cc

    println("-------------")

    map.mapValues { entry -> "${entry.value} hello" }.forEach { println(it) }
    //a=aa hello
    //b=bb hello
    //c=cc hello

    println("-------------")

    map.mapValues { (key, value) -> "$value world" }.forEach { println(it) }
    //a=aa world
    //b=bb world
    //c=cc world

    println("-------------")

    //kotlin允许解构整体指定类型，也可以为一个具体的参数（component）指定类型。
    //下面这个mapValues也才是完整的写法，也可以省略解构的类型。
    map.mapValues { (_, value): Map.Entry<String, String> -> "$value person" }
        .forEach { println(it) }

    map.mapValues { (_, value: String) -> "$value people" }.forEach { println(it) }
    //a=aa person
    //b=bb person
    //c=cc person
    //a=aa people
    //b=bb people
    //c=cc people
}