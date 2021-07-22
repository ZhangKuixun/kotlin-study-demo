package com.kevin.kotlin

/**
 * other：Kevin
 * create time：2021/6/19
 * describe：
 * 接口覆盖
 */
interface A {
    fun method() {
        println("A")
    }
}

open class B {
    open fun method() {
        println("B")
    }
}

class C : A, B() {
    override fun method() {
        super<A>.method()
        super<B>.method()
    }
}

fun main(args: Array<String>) {
    val c = C()
    c.method()
}