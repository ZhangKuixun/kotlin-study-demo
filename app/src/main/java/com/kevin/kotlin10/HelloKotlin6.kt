package com.kevin.kotlin10

/**
 * other：Kevin
 * create time：2021/7/18
 * describe：
 */
//fun main() {
//    val values = listOf("hello", "java", "kotlin")
//    println(values.map(String::length))//[5, 4, 6]
//}
/**
 * 方法中使用属性引用：
 * map传入的参数是一个函数"(T) -> R"，这个函数传入一个类型，返回另一个类型，String::length，length是一个属性，
 * 不需要写参数，从map接收的就是一个String，返回的是一个Int类型，length属性不需写参数。
 */

class MyClass(val x: Int)

fun main() {
    // y表示引用了MyClass类里面的属性x，真正使用y，必须要有一个类的实例，类才真正的创建出来。
    val y = MyClass::x
    // y.get()方法传入MyClass的实例，能获取到MyClass的y值。
    println(y.get(MyClass(1)))
}
/**
 * 访问一个类的成员属性，需要使用全限定名称（MyClass::x），类名::属性，属性才能有接收者。
 * 如果属性没有接收者，用"::属性"。
 */