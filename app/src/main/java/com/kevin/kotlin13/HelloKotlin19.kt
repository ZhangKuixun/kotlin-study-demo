package com.kevin.kotlin13

import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.memberProperties

/**
 * other：Kevin
 * create time：2021/7/21
 * describe：
 * 用反射修改属性
 */
class MyTestClass7 {
    var name: String = "hello"
}

fun main() {
    val kClass = MyTestClass7::class
    val testClass7 = MyTestClass7()
    val variableToInvoke = kClass.memberProperties.find { it.name == "name" }

    println(variableToInvoke?.get(testClass7))//hello

    if (variableToInvoke is KMutableProperty<*>) {
        variableToInvoke.setter.call(testClass7, "welcome")
    }
    println(variableToInvoke?.get(testClass7))//welcome
}
/**
 * 只有KMutableProperty才有修改属性的权限
 */