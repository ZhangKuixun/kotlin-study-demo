package com.kevin.kotlin.basics

/**
 * other：Kevin
 * create time：2021/6/20
 * describe：扩展
 */

fun main() {
    val extensionTest = ExtensionTest()
    println(extensionTest.add(1, 2))// 3
    println(extensionTest.subtract(1, 2))// -1
    println(extensionTest.multiply(1, 2))// 2

    println("-----------")

    myPrint(AA())

    println("-----------")

    CC().foo()

    println("-----------")

    EE().world(DD())
    EE().test()
}

// 扩展
// 什么是扩展：已经定义好了一个类，想要给这个类扩充功能，类似于Java的继承、装饰模式(io流操作，想读什么流就读什么流)
class ExtensionTest {
    fun add(a: Int, b: Int) = a + b
    fun subtract(a: Int, b: Int) = a - b
}

// 扩展方法
fun ExtensionTest.multiply(a: Int, b: Int) = a * b

// 扩展
// 1.扩展并不是真正修改原来的类，不会在原来的类中插入属性或方法
// 2.扩展函数的解析是静态的，而不是动态的，即扩展不支持多态（通过引用父类去指向子类对象），调用只取决于对象的声明类型
// 3.调用是由对象声明类型所决定的，不是由对象的实际类型决定
open class AA
class BB : AA()

fun AA.a() = "a"
fun BB.a() = "b"
fun myPrint(aa: AA) {
    println(aa.a())
}


// 扩展重名的方法
//   优先使用原方法，原方法不满足，在使用扩展方法
//   调用：CC().foo()// 输出：member
class CC {
    fun foo() {
        println("member")
    }
}

fun CC.foo() {
    println("member2")
}


// 对可控类型扩展，可控类型：一个类型后面加一个问号
fun Any?.toString(): String {
    if (null == this)
        return "null"
    return toString()
}



// 扩展的作用域

/*
* 扩展的定义
*   1.扩展函数定义在某个类，这个类实列叫做分发接收者（dispatch receiver）
*   2.扩展函数所扩展的目标类，这个类实例叫做扩展接收者（extension receiver）
*
* 扩展的作用域
*   1.在另一个类里面（分发接收者），定义了一个扩展函数，在这个扩展函数中可以访问扩展接收者的函数，也可以访问分发接收者的成员
*   2.在分发接收者里的函数里，可以调用在本类中定义的扩展函数
*   3.当以上分发接收者或者扩展接收者里的成员名字出现冲突时，扩展接收者的优先级最高
*       3.1.如果想要调用自己的函数名，写法：this@EE.tos()
* */
class DD {
    fun method() {
        println("DD method")
    }

    fun tos() {
        println("DD fun")
    }
}

class EE {
    fun method2() {

    }

    fun DD.hello() {
        method()
        method2()
    }

    fun world(dd: DD) {
        dd.hello()
    }

    fun tos() {
        println("EE fun")
    }

    fun test() {
        DD().output()
    }

    // 调用
    //   EE().test()
    // 输出：
    //   DD fun
    //   EE fun
    fun DD.output() {
        println(toString())
        println(this@EE.toString())
    }
}

/*
* 扩展的作用
*   解决Java中充斥的各种辅助类问题，比如列表的交换方法，必须要把列表传进辅助类里，在辅助类里排序
* 语法改进：
*   Java原语法：Collections.swap(list, 4, 10)
*   kotlin改进语法：list.swap(4, 10)
* */
