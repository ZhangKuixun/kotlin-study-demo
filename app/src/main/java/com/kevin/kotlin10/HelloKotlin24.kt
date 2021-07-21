package com.kevin.kotlin10

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

    val props: Collection<KProperty1<MyTestClass12, *>> = kClass.declaredMemberProperties
    props.forEach {
        when (it.name) {
            "name" -> {
                println(it.get(instance))//kotlin
                val kmp = it as KMutableProperty1<MyTestClass12, Any>
                kmp.set(instance, "java")
                println(it.get(instance))//java
            }
            "price" -> {
                println(it.get(instance))//2.3
            }
        }
    }
}
/**
 * KProperty1<T, out V>：返回一个属性。
 * T：接收者的类型，用于获取属性的值。
 * V：属性本身的类型。
 * KMutableProperty1是可以改变的属性类型。
 */
