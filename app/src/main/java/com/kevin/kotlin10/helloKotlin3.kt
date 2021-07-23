package com.kevin.kotlin10

/**
 * other：Kevin
 * create time：2021/7/17
 * describe：
 * 可变参数：
 * kotlin调用java有可变参数的方法，kotlin用"*"把数组打散。
 */
fun main() {
    val myVarargs = MyVarargs()
    val arrayOf = arrayOf("hello", "world", "java")
    myVarargs.myMethod(*arrayOf)
}