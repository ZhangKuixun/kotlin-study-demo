package com.kevin.kotlin

/**
 * other：Kevin
 * create time：2021/6/20
 * describe：
 * 延迟属性 lateinit
 * Kotlin要求非空类型的属性必须在构造方法中进行初始化
 * 有时这种要求不方便，比如可以通过依赖注入或是单元测试情况下，对属性赋值
 * 通过lateinit关键字标识属性为延迟初始化，需要满足三个条件：
 * 1.lateinit只能用在类体中申明的var属性上，不能用在primary constructor的属性申明
 * 2.属性不能有自定义的get和set方法
 * 3.属性类型要为非空，不能是原生数据类型
 * 原生数据类型: - lateinit var name: Int
 */
class TheClass {
    lateinit var name: String

    fun init() {
        this.name = "zhangsan"
    }

    fun print() {
        println(this.name)
    }
}

fun main() {
    val theClass = TheClass()
    theClass.init()
    theClass.print()
}