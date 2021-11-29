package com.kevin.kotlin13

import kotlin.reflect.KMutableProperty0
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.KProperty1

/**
 * other：Kevin
 * create time：2021/7/21
 * describe：
 * 反射修改包级别的属性
 */
class MyTestClass13 {
    var name: String = "kotlin"
    val price: Double = 2.3
}

var test = "test"

fun main() {
    // 修改包级别的属性
    val topProp: KMutableProperty0<String> = ::test
    topProp.set("修改的值")
    println(topProp.get())//修改的值

    // 修改类里的可读写属性
//    val myTestClass13 = MyTestClass13::class
//    var name = MyTestClass13::name
//    println(name)//var com.kevin.kotlin10.MyTestClass13.name: kotlin.String
//    name.set(MyTestClass13(), "android")

    // 修改类里的可读写属性
    val myTestClass13 = MyTestClass13()
    val name: KMutableProperty1<MyTestClass13, String> = MyTestClass13::name
    name.set(myTestClass13, "java")
    println(name.get(myTestClass13))//java

    // 获取类里的只读属性
    val prop: KProperty1<MyTestClass13, Double> = MyTestClass13::price
    println(prop.get(myTestClass13))
//    val price: KMutableProperty1<MyTestClass13, Double> =
//        prop as KMutableProperty1<MyTestClass13, Double>
//    price.set(myTestClass13, 2.5)
}
