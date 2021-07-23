package com.kevin.kotlin13

/**
 * other：Kevin
 * create time：2021/7/18
 * describe：
 * 反射：
 * java的反射入口是Class，kotlin反射入口是KClass。
 *
 */
fun main() {
    val c = String::class
    println(c)//class kotlin.String

    // String::class.java：一个属性，用给定的KClass实例返回一个java的Class实例。
    val c2 = String::class.java
    println(c2)//class java.lang.String
}