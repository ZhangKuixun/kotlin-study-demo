package com.kevin.kotlin

open class MyParent {
    open fun method() {
        println("parent method")
    }

    open val name: String get() = "parent"
}

/**
 * 1.val 可以 override val
 * 2.var 可以 override val
 * 3.val 可以 override var
 *
 * 本质上，val相当于get方法；var相当于get与set方法。
 */
class MyChild : MyParent() {
    override fun method() {
        super.method()
        println("child method")
    }

    override val name: String
        get() = super.name + " and child"
}

fun main() {
    val child = MyChild()
    child.method()//parent method    child method
    println(child.name)//parent and child
}