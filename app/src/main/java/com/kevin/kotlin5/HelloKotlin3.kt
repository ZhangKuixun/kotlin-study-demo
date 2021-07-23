package com.kevin.kotlin5

/**
 * other：Kevin
 * create time：2021/6/29
 * describe：
 * 中缀符号（infix notation）
 * 函数还可以通过中缀符号调用，满足下面三个条件：
 * 1.是成员函数或扩展函数，就是要依托于具体的函数或具体的类
 * 2.函数必须只有一个参数
 * 3.用infix关键字申明函数
 */
class infixTest(private var a: Int) {
    infix fun add(b: Int) = this.a + b
}

fun main() {
    val infixTest = infixTest(1)
    //下面两种方式是等价的
    println(infixTest.add(5))
    println(infixTest add 5)//中缀调用法
}