package com.kevin.kotlin9

/**
 * other：Kevin
 * create time：2021/7/18
 * describe：
 * kotlin类中有setA()、getA()，再定义一个变量A，又会生成一个getA()、setA()，编译时也会报平台声明冲突。
 * Platform declaration clash: The following declarations have the same JVM signature (getA()I)
 * 解决：kotlin注解 @JvmName()
 */
class MyClass {
    val a: Int
        @JvmName("getAValue")
        get() = 2

    fun getA() = 3
}

fun main() {
    val myClass = MyClass()
    println(myClass.a)//2
    println(myClass.getA())//3
}