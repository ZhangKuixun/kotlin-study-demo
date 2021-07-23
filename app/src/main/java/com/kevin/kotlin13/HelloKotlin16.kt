package com.kevin.kotlin13

/**
 * other：Kevin
 * create time：2021/7/21
 * describe：
 * 获取类的构造方法
 */
class MyTestClass4(value: Int) {
    constructor(amount: Int, color: String) : this(amount) {
        println("secondary constructor")
    }
    constructor(amount: Int, full: Boolean) : this(amount) {
        println("secondary constructor")
    }
    fun printSomething() {
        println("something")
    }
}

fun main() {
    val myTestClass4 = MyTestClass4::class
    val constructors = myTestClass4.constructors
    println(constructors)
    //[fun <init>(kotlin.Int, kotlin.String): com.kevin.kotlin10.MyTestClass4,
    // fun <init>(kotlin.Int, kotlin.Boolean): com.kevin.kotlin10.MyTestClass4,
    // fun <init>(kotlin.Int): com.kevin.kotlin10.MyTestClass4]
}