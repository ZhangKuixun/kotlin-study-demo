package com.kevin.kotlin10

import kotlin.reflect.KFunction
import kotlin.reflect.full.createInstance

/**
 * other：Kevin
 * create time：2021/7/21
 * describe：
 * 反射调用构造方法
 */
class MyTestClass10(var name: String) {
    var price = 0.0

    constructor() : this("未知商品") {
        this.price = 0.0
    }

    constructor(name: String, price: Double) : this(name) {
        this.price = price
    }
}

fun main() {
    val kClass = MyTestClass10::class
    val createInstance = kClass.createInstance()
    println(createInstance.name)//未知商品
    println(createInstance.price)//0.0

    val constructors: Collection<KFunction<MyTestClass10>> = kClass.constructors
    constructors.forEach {
        if (it.parameters.size == 2) {
            val constructor: MyTestClass10 = it.call("kotlin", 1.2)
            println(constructor.name)//kotlin
            println(constructor.price)//1.2
        }
    }
}
/**
 * parameters：KFunction参数的集合。返回一个KParameter类型的列表，如果KFunction需要一个this实例或者
 * 扩展接收者参数，它位于列表中的第一个。
 * call()调用构造方法不需要写类的实例对象，it.call("kotlin", 1.2)。
 */