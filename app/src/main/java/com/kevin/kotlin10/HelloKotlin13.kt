package com.kevin.kotlin10

import java.io.Serializable
import kotlin.reflect.full.superclasses


/**
 * other：Kevin
 * create time：2021/7/20
 * describe：
 */
class MySerializableClass : Serializable, MyInterface

fun main() {
    // 获取父类的泛型
    val kClass = MySerializableClass::class
    val list = kClass.superclasses
    println(list)//[class java.io.Serializable, class kotlin.Any]
    // 为什么有两个父类？因为Any是所有kotlin类的根类。

    // 让MySerializableClass实现自己定义的一个接口。
    // 打印[class java.io.Serializable, class com.kevin.kotlin10.MyInterface, class kotlin.Any]
}

interface MyInterface

