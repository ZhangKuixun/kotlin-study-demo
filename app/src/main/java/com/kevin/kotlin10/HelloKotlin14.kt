package com.kevin.kotlin10

import kotlin.reflect.full.memberProperties


/**
 * other：Kevin
 * create time：2021/7/20
 * describe：
 */
class MyTestClass2(var a: String, val flag: Boolean, var age: Int)

fun main() {
    // 获取成员属性
    val myTestClass2 = MyTestClass2::class
    println(myTestClass2.memberProperties)
    //[var com.kevin.kotlin10.MyTestClass2.a: kotlin.String,
    // var com.kevin.kotlin10.MyTestClass2.age: kotlin.Int,
    // val com.kevin.kotlin10.MyTestClass2.flag: kotlin.Boolean]
}

