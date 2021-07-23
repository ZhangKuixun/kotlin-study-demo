package com.kevin.kotlin12

/**
 * other：Kevin
 * create time：2021/7/18
 * describe：
 * Java调用kotlin的null对象：
 * kotlin对空的处理非常严格，如：一个String对象不能往里传空值，java可以往一个String对象传入空值。
 */
class MyClass4 {
    fun method(str: String) {
        println("method invoked")
        println(str)
    }
}