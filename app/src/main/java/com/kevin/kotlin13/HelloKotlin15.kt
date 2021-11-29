package com.kevin.kotlin13

import kotlin.reflect.full.memberFunctions


/**
 * other：Kevin
 * create time：2021/7/20
 * describe：
 *
 * 获取方法
 *
 * kClass.memberFunctions
 * 返回一个KFunction类型的集合，KFunction代表一个函数能够，找到这个函数，然后调用函数。
 * KFunction和Java的Method做的事情一样。
 */
class MyTestClass3() {
    fun printSomething() {
        println("something")
    }

    fun printNothing() {
        println("")
    }
}

fun main() {
    // 获取类的方法
    val kClass = MyTestClass3::class
    println(kClass.memberFunctions)
    //[fun com.kevin.kotlin10.MyTestClass3.printNothing(): kotlin.Unit,
    // fun com.kevin.kotlin10.MyTestClass3.printSomething(): kotlin.Unit,
    // fun com.kevin.kotlin10.MyTestClass3.equals(kotlin.Any?): kotlin.Boolean,
    // fun com.kevin.kotlin10.MyTestClass3.hashCode(): kotlin.Int,
    // fun com.kevin.kotlin10.MyTestClass3.toString(): kotlin.String]
}

