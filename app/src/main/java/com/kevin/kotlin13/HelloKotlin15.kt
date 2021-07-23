package com.kevin.kotlin13

import kotlin.reflect.full.memberFunctions


/**
 * other：Kevin
 * create time：2021/7/20
 * describe：
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
    val myTestClass3 = MyTestClass3::class
    println(myTestClass3.memberFunctions)
    //[fun com.kevin.kotlin10.MyTestClass3.printNothing(): kotlin.Unit,
    // fun com.kevin.kotlin10.MyTestClass3.printSomething(): kotlin.Unit,
    // fun com.kevin.kotlin10.MyTestClass3.equals(kotlin.Any?): kotlin.Boolean,
    // fun com.kevin.kotlin10.MyTestClass3.hashCode(): kotlin.Int,
    // fun com.kevin.kotlin10.MyTestClass3.toString(): kotlin.String]
}

