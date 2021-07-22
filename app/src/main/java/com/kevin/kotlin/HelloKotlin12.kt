package com.kevin.kotlin

/**
 * other：Kevin
 * create time：2021/7/22
 * describe：
 * 构造方法：
 * 在JVM上，如果primary构造方法的参数都有默认值，kotlin编译器会生成不带参数的构造方法，这个不带参数构造方法会
 * 使用primary构造方法中的参数的默认值。
 * 原因：适配其他的框架，比如：spring，这些框架对接kotlin代码的时候，调用的是不带参数的构造方法
 */
class Person constructor(username: String) {// primary构造方法

    private var username: String// 不写初始值会报错，必须写，或者在init{} 中写，
    private var age: Int
    private var address: String// 地址

    init {
        println(username)

        this.username = username
        this.age = 20
        this.address = "北京"
    }

    // secondary构造方法
    constructor(username: String, age: Int)
            : this(username) {// 必须要直接或简介调用primary构造方法
        println("$username, $age")

        this.username = username
    }

    // secondary构造方法
    constructor(username: String, age: Int, address: String)
            : this(username, age) {// 必须要直接或简介调用primary构造方法
        this.address = address
    }

    fun printInfo() {
        println("username:${this.username}, age:${this.age}, address:${this.address}")
    }
}

fun main() {
    val person = Person("zhangsan")//zhangsan

    println("---------")
    val person1 = Person("lisi", 30)//lisi  lisi, 30

    println("---------")
    val person2 = Person("wangwu", 40, "chengdu")//wangwu  wangwu, 40

    println("---------")
    person.printInfo()

    println("---------")
    person1.printInfo()

    println("---------")
    person2.printInfo()
}