package com.kevin.kotlin3

/**
 * other：Kevin
 * create time：2021/6/26
 * describe：
 * 内部类
 */
class OuterClass2 {
    private val str: String = "hello world"

    inner class InnerClass {
        fun innerMethod() = this@OuterClass2.str
    }

    // 局部嵌套类
    fun getName(): String {
        class LocalNestedClass {
            val name: String = "mytest"
        }

        val localNestedClass = LocalNestedClass()
        return localNestedClass.name
    }
}

fun main() {
    println(OuterClass2().InnerClass().innerMethod())

    println(OuterClass2().getName())
}

/**
 * 嵌套类和内部类的区别：
 * 1.嵌套类：就相当于静态内部类，嵌套类里面的成员是普通的成员
 * 2.内部类：就相当于普通的内部类，用inner修饰类，创建的时候，需要先创建外部类的实例，再创建内部类，
 * 内部类的成员都是普通成员，当创建好了外部类实例的时候，内部类会持有外部类的引用
 *
 * 嵌套类只能访问嵌套类，本质就是，非静态的能访问一切，静态只能访问静态
 */
