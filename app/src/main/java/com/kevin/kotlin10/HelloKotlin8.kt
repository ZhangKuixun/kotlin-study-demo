package com.kevin.kotlin10

import kotlin.reflect.jvm.javaField
import kotlin.reflect.jvm.javaGetter

/**
 * other：Kevin
 * create time：2021/7/18
 * describe：
 */
class T(val x: Int)

fun main() {
    println(T::x.javaGetter)//public final int com...T.getX()
    println(T::x.javaField)//private final int com...T.x

    println("------------")
    //返回这个对象的运行时java类
    println(T(10).javaClass)//class com...T
    //返回给定的java实例所对应的kotlin类
    println(T(10).javaClass.kotlin)//class com...T

    println(String.javaClass)//class kotlin.jvm.internal.StringCompanionObject
    println(String.javaClass.kotlin)//class kotlin.String$Companion

    /**
     * 自己写的类反射获取到的类和String反射获取到的类不一样。
     */
}