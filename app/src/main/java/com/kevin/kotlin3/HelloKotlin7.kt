package com.kevin.kotlin3

/**
 * other：Kevin
 * create time：2021/6/26
 * describe：
 * 匿名对象类型，满足任意一点即可：
 * 匿名对象只能在局部变量范围内或是被private修饰的成员变量范围内才能被当作他自己的类型。
 * 如果将匿名对象当作一个public方法的返回类型或是public属性的类型，当前方法、属性的类型就是匿名对象所声明的父类型。
 * 如果没有声明任何父类型，那么其类型就是Any，匿名对象中所申明的任何成员都是无法访问的。
 */
class MyClass1 {
    private var myObject = object {
        fun output() {
            println("output invoked")
        }
    }

    fun myTest() {
        println(myObject.javaClass)
        println(myObject::class.java)
        myObject.output()
    }
}

class MyClass2 {
    private fun method1() = object {
        var str = "hello"
    }

    internal fun method2() = object {
        var str = "world"
    }

    fun test() {
        val str = method1().str
        // val str1 = method2().method2//编译错误
    }
}

fun main() {
    val myClass = MyClass1()
    myClass.myTest()
}