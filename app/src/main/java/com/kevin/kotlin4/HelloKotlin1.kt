package com.kevin.kotlin4

/**
 * other：Kevin
 * create time：2021/6/27
 * describe：
 * 委托（delegation）
 * 自己有事情让A去完成，A让B去完成，这就是委托
 *
 * 类委托
 */
interface MyInterface {
    fun myPrint()
}

class MyInterfaceImpl(var str: String) : MyInterface {
    override fun myPrint() {
        println("welcome $str")
    }
}

class MyClass(myInterface: MyInterface) : MyInterface by myInterface {
    override fun myPrint() {
        println("hello world")
    }
}

fun main() {
    val myInterfaceImpl = MyInterfaceImpl("ZhangSan")
    val myClass = MyClass(myInterfaceImpl)
    myClass.myPrint()//hello world
}

/**
 * class MyClass(myInterface: MyInterface) : MyInterface by myInterface
 * 分析：
 * 1.by后面的名字，必须用MyClass的参数myInterface
 * 2.如果MyClass类自己实现了MyInterface接口的myPrint方法，优先使用自己的
 *
 * 委托原理：
 * by关键字后面的对象实际上会被存储在类的内部，编译器则会把父接口中所有的方法实现出来，并且把实现转移给委托对象去进行。
 */