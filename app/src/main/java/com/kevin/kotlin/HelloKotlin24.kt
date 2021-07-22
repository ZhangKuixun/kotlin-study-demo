package com.kevin.kotlin

/**
 * other：Kevin
 * create time：2021/6/20
 * describe：
 * 扩展
 * 1.扩展并不是真正修改原来的类，不会在原来的类中插入属性或方法
 * 2.扩展函数的解析是静态的，而不是动态的，即扩展不支持多态（通过引用父类去指向子类对象），调用只取决于对象的声明类型
 * 3.调用是由对象声明类型所决定的，不是由对象的实际类型决定
 */
open class AA
class BB : AA()

fun AA.a() = "a"
fun BB.a() = "b"
fun myPrint(aa: AA) {
    println(aa.a())
}

fun main() {
    myPrint(AA())
    myPrint(BB())
}
