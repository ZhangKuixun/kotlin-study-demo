package com.kevin.kotlin10

import kotlin.reflect.full.companionObject

/**
 * other：Kevin
 * create time：2021/7/21
 * describe：
 * 反射获取伴生对象
 */
class MyTestClass8 {
    companion object {
        fun method() {
            println("hello world")
        }
    }
}

fun main() {
    val kClass = MyTestClass8::class
    val companionObject = kClass.companionObject

    println(companionObject)//class com.kevin.kotlin10.MyTestClass8$Companion

    MyTestClass8.method()//hello world
}