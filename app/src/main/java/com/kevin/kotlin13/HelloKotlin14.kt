package com.kevin.kotlin13

import kotlin.reflect.full.memberProperties


/**
 * other：Kevin
 * create time：2021/7/20
 * describe：
 * 获取成员属性
 *
 * kClass.memberProperties
 * 返回KProperty1类型的集合，KProperty1可以获取属性。
 */
class MyTestClass2(var a: String, val flag: Boolean, var age: Int)

fun main() {
    // 获取成员属性
    val kClass = MyTestClass2::class
    println(kClass.memberProperties)
    //[var com.kevin.kotlin10.MyTestClass2.a: kotlin.String,
    // var com.kevin.kotlin10.MyTestClass2.age: kotlin.Int,
    // val com.kevin.kotlin10.MyTestClass2.flag: kotlin.Boolean]
}

