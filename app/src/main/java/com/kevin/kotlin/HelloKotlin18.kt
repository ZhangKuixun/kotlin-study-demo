package com.kevin.kotlin

/**
 * other：Kevin
 * create time：2021/6/19
 * describe：
 * 抽象类
 */
// 抽象类
open class BaseClass {
    open fun method() {
    }
}

abstract class ChildClass : BaseClass() {
    abstract override fun method()// 可以用abstract修饰override方法
}



