package com.kevin.kotlin10

import kotlin.reflect.full.createInstance

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
    val createInstance = kClass.createInstance()
    createInstance.printNothing()//Nothing
}