package com.kevin.kotlin13

import kotlin.reflect.full.functions

/**
 * other：Kevin
 * create time：2021/7/21
 * describe：
 * 用反射调用方法
 */
class MyTestClass5 {
    fun printNothing() {
        println("nothing")
    }

    fun printSomething(name: String) {
        println("something:$name")
    }
}

fun main() {
    val kClass = MyTestClass5::class
    val myTestClass5 = MyTestClass5()

    // 调用无参方法
    val functionToInvoke = kClass.functions.find { it.name == "printNothing" }
    functionToInvoke?.call(myTestClass5)

    // 调用有参方法
    val printSomething = kClass.functions.find { it.name == "printSomething" }
    printSomething?.call(myTestClass5, "hello")
}
/**
 * 1.获取KClass。
 * 2.创建类的实例，调用方法需要基于实例去调用。
 * 3.反射获取需要调用的方法。
 * 4.用call()执行调用。
 * call等价java的invoke方法。call的参数是一个可变参数，call方法有指定的参数列表并且返回结果，
 * 如果指定的参数不能等于参数列表的数量或者类型不匹配，会抛出异常。
 */