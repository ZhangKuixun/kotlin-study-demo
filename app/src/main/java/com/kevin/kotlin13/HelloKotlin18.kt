package com.kevin.kotlin13

import kotlin.reflect.full.memberProperties

/**
 * other：Kevin
 * create time：2021/7/21
 * describe：
 * 用反射读取属性
 */
class MyTestClass6 {
    var name: String = "hello"
}

fun main() {
    val kClass = MyTestClass6::class
    val myTestClass6 = MyTestClass6()
    val variableToInvoke = kClass.memberProperties.find { it.name == "name" }
    println(variableToInvoke?.get(myTestClass6))//hello
    println(variableToInvoke?.call(myTestClass6))//hello
}
/**
 */