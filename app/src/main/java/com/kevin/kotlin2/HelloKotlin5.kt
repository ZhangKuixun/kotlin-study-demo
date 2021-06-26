package com.kevin.kotlin2

/**
 * other：Kevin
 * create time：2021/6/26
 * describe：
 */

/**
 * 对象表达式（object expression）
 * Kotlin的对象表达式解决了匿名内部类的缺陷，就相当于Java的匿名内部类
 *
 * Java匿名内部类：
 *   1.匿名内部类没有名字的类
 *   2.匿名内部类一定是继承了某一个父类，或者实现了某一个接口
 *   3.Java运行时将该匿名内部类当作它所实现的接口或是继承的父类来看待
 *   第2点和第3点都是缺陷
 *
 * 格式：
 * object [:若干个父类，中间用逗号分隔] {
 * }
 * [:若干个父类新，中间用逗号分隔]可以省略
 */

interface MyInterface {
    fun myPrint(i: Int)
}

abstract class MyAbstractClass {
    abstract val age: Int
    abstract fun printMyAbstractClassInfo()
}

fun main() {
    val myObject = object : MyInterface {
        override fun myPrint(i: Int) {
            println("i的值是$i")
        }
    }
    myObject.myPrint(100)

    println("-------省略接口------")

    val myObject2 = object {
        init {
            println("初始化块执行")
        }

        var myProperty = "Hello world"
        fun myMethod() = "myMethod"
    }
    println(myObject2.myProperty)
    println(myObject2.myMethod())

    println("-------同时实现接口和抽象类------")

    val myObject3 = object : MyInterface, MyAbstractClass() {
        override fun myPrint(i: Int) {
            println("i的值是$i")
        }

        override val age: Int
            get() = 30

        override fun printMyAbstractClassInfo() {
            println("printMyAbstractClassInfo invoked")
        }
    }
    println(myObject3.myPrint(20))
    println(myObject3.age)
    println(myObject3.printMyAbstractClassInfo())
}
/**
 * Java中，匿名内部类一定是继承了某一个父类，或者实现了某一个接口。
 * Kotlin中，可以不写接口名字或者抽象类。
 *
 * Java中，会把匿名内部类当作它所实现的接口或是继承的父类来看待。
 * Kotlin中，可以继承多个父类或实现多个接口，可以把匿名内部类当作任意一个继承的父类或者实现的接口来看待。
 */

