package com.kevin.kotlin3

/**
 * other：Kevin
 * create time：2021/6/26
 * describe：
 * 对象表达式（object expression）
 *
 * Kotlin的对象表达式解决了匿名内部类的缺陷，就相当于Java的匿名内部类
 *
 * Java匿名内部类：
 *   1.匿名内部类没有名字的类
 *   2.匿名内部类一定是继承了某一个父类，或者实现了某一个接口
 *   3.Java运行时将该匿名内部类当作它所实现的接口或是继承的父类来看待
 *   第2点和第3点都是缺陷
 *
 * 格式：
 * object [:若干个父类型，中间用逗号分隔] {
 * }
 * [:若干个父类型，中间用逗号分隔]可以省略
 *
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
            println("i的值是$i")//i的值是100
        }
    }
    myObject.myPrint(100)

    println("-------省略接口------")

    val myObject2 = object {
        init {
            println("初始化块执行")//运行立即打印
        }

        var myProperty = "Hello world"
        fun myMethod() = "myMethod"
    }
    println(myObject2.myProperty)//Hello world
    println(myObject2.myMethod())//myMethod

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
    myObject3.myPrint(20)//i的值是20
    println(myObject3.age)//30
    myObject3.printMyAbstractClassInfo()//printMyAbstractClassInfo invoked
}

/**
 * Java中，匿名内部类一定是继承了某一个父类，或者实现了某一个接口。
 * Kotlin中，可以不写接口名字或者抽象类。
 *
 * Java中，会把匿名内部类当作它所实现的接口或是继承的父类来看待。
 * Kotlin中，可以继承多个父类或实现多个接口，可以把匿名内部类当作任意一个继承的父类或者实现的接口来看待。
 */