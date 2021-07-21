package com.kevin.kotlin10

import kotlin.reflect.KFunction
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.declaredFunctions

/**
 * other：Kevin
 * create time：2021/7/21
 * describe：
 * 反射调用构造方法
 */
class MyTestClass11 {
    fun method(message: String) {
        println("执行带String参数的方法：$message")
    }

    fun method(message: String, price: Double) {
        println("执行带String,Double参数的方法：$message $price")
    }
}

fun main() {
    val kClass = MyTestClass11::class
    val instance = kClass.createInstance()

    val funs = kClass.declaredFunctions
    for (f: KFunction<*> in funs) {
        if (f.parameters.size == 3) {
            f.call(instance, "kotlin", 1.3)
        }
        if (f.parameters.size == 2) {
            f.call(instance, "java")
        }
    }
}
/**
 * declaredFunctions：获取到由KClass对象对应的类里面所有的方法。
 *
 * KFunction.parameters.size：获取函数参数的数量
 * 如果面对的是普通方法，从第二个参数开始，才是方法真正的第一个参数。
 * 如果面对的是构造方法，构造方法有几个参数，size返回的就是几。
 *
 * f.call(instance, "kotlin", 1.3)
 * call调用普通的方法时，方法的第一个参数是被调用的方法对应的实例，从call的第二个参数开始，才是方法真正的第一个参数。
 * call调用构造方法，按照参数的顺序传递即可。
 */