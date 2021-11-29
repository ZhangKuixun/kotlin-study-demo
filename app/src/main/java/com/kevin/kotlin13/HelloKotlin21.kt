package com.kevin.kotlin13

import kotlin.reflect.full.createInstance
import kotlin.reflect.full.functions

/**
 * other：Kevin
 * create time：2021/7/21
 * describe：
 * 反射获取类的实例
 */
class MyTestClass9(vale: Int = 0) {
    fun printSomething() {
        println("Something")
    }

    fun printNothing() {
        println("Nothing")
    }
}

fun main() {
    val kClass = MyTestClass9::class
    // 获取类的实例
    val createInstance = kClass.createInstance()
    createInstance.printNothing()//Nothing

    // 通过实例调用方法
    kClass.functions.find { it.name == "printSomething" }?.call(createInstance)
    kClass.functions.find { it.name == "printNothing" }?.call(createInstance)
}