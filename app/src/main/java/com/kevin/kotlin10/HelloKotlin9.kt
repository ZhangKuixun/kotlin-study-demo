package com.kevin.kotlin10


/**
 * other：Kevin
 * create time：2021/7/18
 * describe：
 * 构造方法引用（Constructor Reference）
 * 构造方法引用的形式和方法引用、属性引用，是一样的写法"::构造方法"。
 * 应用场景：前提是有一个函数和一个类，函数的参数是函数类型，函数类型的参数和类的构造方法的参数一样，函数类型返回的也是这个类的实例。
 */

class B(val x: Int)

fun myMethod(factory: (x: Int) -> B) {
    val b: B = factory(3)
    println(b.x)
}

fun main() {
    myMethod(::B)//3
}