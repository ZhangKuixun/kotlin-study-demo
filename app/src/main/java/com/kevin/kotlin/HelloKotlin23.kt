package com.kevin.kotlin

/**
 * other：Kevin
 * create time：2021/6/20
 * describe：
 * 扩展
 * 什么是扩展：已经定义好了一个类，想要给这个类扩充功能，类似于Java的继承、装饰模式(io流操作，想读什么流就读什么流)
 */
class ExtensionTest {
    fun add(a: Int, b: Int) = a + b
    fun subtract(a: Int, b: Int) = a - b
}

// 扩展方法
fun ExtensionTest.multiply(a: Int, b: Int) = a * b

fun main() {
    val extensionTest = ExtensionTest()
    println(extensionTest.add(1, 2))// 3
    println(extensionTest.subtract(1, 2))// -1
    println(extensionTest.multiply(1, 2))// 2
}