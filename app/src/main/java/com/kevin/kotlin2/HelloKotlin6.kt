package com.kevin.kotlin2

import android.annotation.SuppressLint


/**
 * other：Kevin
 * create time：2021/6/22
 * describe：
 * use-site variance(type projection)类型投影
 */

@SuppressLint("Assert")
fun copy(from: Array<out Any>, to: Array<Any>) {
    assert(from.size == to.size)

    for (i in from.indices) {
        to[i] = from[i]
    }
}

/**
 * from: Array<out Any>：不能再往参数from写入数据，只能读取数据，这种就是使用处协变，也叫类型投影
 *
 * 本质来看：
 * 假如 from: Array<out Any> 不加out，copy(from, to)能成功，把 from: Array<Int>写入到 from: Array<out Any>，
 * from: Array<out Any> 就变成了 from: Array<Int>，然后 to[i] = from[i] 就相当于把 String写入到Int，就不能写入。
 */

fun main() {
    val from: Array<Int> = arrayOf(1, 2, 3, 4)
    val to: Array<Any> = Array(4) { "hello$it" }

    for (item in to) {
        println(item)
    }
    //hello0
    //hello1
    //hello2
    //hello3

    copy(from, to)

    println("------------")
    val array: Array<String> = Array(4) { "hello" }
    for (item in array) {
        println(item)
    }
    //hello
    //hello
    //hello
    //hello

    println("------------")
    setValue(array, 0, "world")
    for (item in array) {
        println(item)
    }
    //world
    //hello
    //hello
    //hello

    println("------------")
    val array2: Array<Any> = Array(4) { "hello$it" }
    for (item in array2) {
        println(item)
    }
    //hello0
    //hello1
    //hello2
    //hello3
    setValue(array2, 1, "world")
}

/**
 * 本质来看：to: Array<in String>，in表示逆变，传入的setValue的时候使用的是Array<Any>类型，Array<Any>是Array<in String>的父类型，
 * 在setValue的方法中，String类型的value写入Array<Any>类型的array2，可以被写入。
 */

fun setValue(to: Array<in String>, index: Int, value: String) {
    to[index] = value
}

/**
 * Kotlin声明处协变和使用处协变的写法区别：
 * 声明处协变：out T，in T
 * 使用处协变：out Any，in String
 */