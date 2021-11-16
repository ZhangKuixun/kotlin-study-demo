package com.kevin.kotlin4

import kotlin.reflect.KProperty

/**
 * other：Kevin
 * create time：2021/6/27
 * describe：
 * 属性委托
 */
class MyDelegate {
    //参数1：委托对象；参数2：委托的属性
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String =
        "$thisRef, your delegate name is ${property.name}"

    //参数1：委托对象；参数2：委托的属性；参数3：新的值
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) =
        println("$thisRef, new value is $value")
}

class MyPropertyClass {
    var str: String by MyDelegate()
}

fun main() {
    val myPropertyClass = MyPropertyClass()
    myPropertyClass.str = "hello world"//MyPropertyClass, new value is hello world
    println(myPropertyClass.str)//MyPropertyClass, your delegate name is str
}
/**
 * MyDelegate的getValue、setValue必须这样写，如果MyDelegate不写，它的父类会定义这两个方法。
 * MyDelegate的operator，表示运算符，myPropertyClass.str调用的是MyDelegate的setValue方法，主要就是operator在起作用。
 *
 * 有四种情况在实际开发中比较有作用：
 * 1.延迟属性。
 * 2.可观测属性。当给一个属性赋值的时候，这个属性就相当于一个监听器一样，在赋值之前或者赋值之后，监听器收到相应的通知，执行预先或事后的处理。
 * 3.非空属性。
 * 4.map委托。
 */