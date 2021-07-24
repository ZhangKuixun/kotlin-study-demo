package com.kevin.kotlin13


/**
 * other：Kevin
 * create time：2021/7/18
 * describe：
 * 构造方法引用（Constructor Reference）
 * 构造方法引用的形式和方法引用、属性引用，是一样的写法"::构造方法"。
 * 应用场景：前提是有一个函数和一个类，函数的参数是函数类型，函数类型的参数和类的构造方法的参数一样，函数类型返回的也是这个类的实例。
 *
 * 要求：
 * 1.函数对象的参数要与构造方法的参数保持一致（参数的个数和参数类型都要一样）。
 * 2.函数对象的返回结果要与构造方法所在类的类型保持一致。
 */

class B(val x: Int)

fun myMethod(factory: (x: Int) -> B) {
    val b: B = factory(3)
    println(b.x)
}

fun main() {
    myMethod(::B)//3
}