package com.kevin.kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class HelloWorldDemo2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.support_simple_spinner_dropdown_item)
    }


}

// 空类
class EmptyClass

/*
* 在kotlin中，一个类可以有一个primary构造方法，以及多个secondary构造方法
* primary构造方法是类头的一部分，它位于类名后面，左花括号前面，可以有若干参数
* 什么情况下可以不写constructor关键字：primary构造方法没有任何注解或者关键字修饰
* */
class MyClass constructor(username: String) {
    init {
        // 这是默认的初始化函数，可以使用primary构造函数的任何参数
        // 类首先执行的方法
    }
}


class Person
constructor(username: String) {// primary构造方法

    private var username: String// 不写初始值会报错，必须写，或者在init{} 中写，
    private var address: String// 地址

    init {
        println(username)

        this.username = username
        this.address = "北京"
    }

    // secondary构造方法
    constructor(username: String, age: Int)
            : this(username) {// 必须要直接或简介调用primary构造方法
        println("$username,$age")

        this.username = username
    }

    // secondary构造方法
    constructor(username: String, age: Int, address: String)
            : this(username, age) {// 必须要直接或简介调用primary构造方法
        this.address = address
    }
}

/*
* 在JVM上，如果primary构造方法的参数都有默认值，kotlin编译器会生成不带参数的构造方法，这个不带参数构造方法会使用primary构造方法中的参数的默认值
* 原因：适配其他的框架，比如：spring，这些框架对接kotlin代码的时候，调用的是不带参数的构造方法
* */
