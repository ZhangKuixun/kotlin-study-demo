package com.kevin.kotlin

/**
 * other：Kevin
 * create time：2021/7/22
 * describe：
 * 构造方法：
 * 在kotlin中，一个类可以有一个primary构造方法，以及多个secondary构造方法。
 * primary构造方法是类头的一部分，它位于类名后面，左花括号前面，可以有若干参数。
 * 什么情况可以不写constructor关键字？主构造方法没有任何注解或关键字修饰。
 * class Person(firstName: String) {}
 *
 * 什么情况必须写constructor关键字？构造函数有注解或可见性修饰符。
 * class Customer public @Inject constructor(name: String) {}
 */
class MyClass constructor(username: String) {
    init {
        // 这是默认的初始化函数，可以使用primary构造函数的任何参数
        // 类首先执行的方法
        println(username)//zhangsan
    }
}

fun main() {
    var myClass = MyClass("zhangsan")
}