package com.kevin.kotlin13

import kotlin.reflect.KMutableProperty1
import kotlin.reflect.KProperty1
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.declaredMemberProperties

/**
 * other：Kevin
 * create time：2021/7/21
 * describe：
 * 反射修改属性
 */
class MyTestClass12 {
    var name: String = "kotlin"
    val price: Double = 2.3
}

fun main() {
    val kClass = MyTestClass12::class
    val instance = kClass.createInstance()

    val props = kClass.declaredMemberProperties
    props.forEach {
        when (it.name) {
            // 修改name值
            "name" -> {
                println(it.get(instance))//kotlin
                // 转换成KMutableProperty1，修改name的值
                val kmp = it as KMutableProperty1<MyTestClass12, Any>
                kmp.set(instance, "java")
                println(it.get(instance))//java
            }
            // 获取price值
            "price" -> {
                println(it.get(instance))//2.3
            }
        }
    }
}
/**
 * KProperty1<T, out V>：返回一个属性。
 * T：获取属性的值。
 * V：属性本身的类型。
 * KMutableProperty1是可以改变的属性类型。
 */
