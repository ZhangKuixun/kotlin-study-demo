package com.kevin.kotlin13

/**
 * other：Kevin
 * create time：2021/7/20
 * describe：
 * 引用特定对象的一个实例方法，也可以引用特定对象的属性。
 */

fun main() {
    val str = "abc"
    val getReference = str::get
    println(getReference(1))//b

    val length = "test"::length
    println(length.get())//4

    val length1 = String::length.get("test")
    println(length1)
}


