package com.kevin.kotlin11

/**
 * other：Kevin
 * create time：2021/7/17
 * describe：
 * java调用kotlin伴生对象中的方法
 * kotlin中，将具名对象或者伴生对象里面定义的方法注解为@JvmStatic，编译器会在类中生成静态方法，
 * 也会在具名对象或者伴生对象中生成实例方法。
 */
class MyClass2 {
    companion object {
        fun test1() {
            println("test1")
        }

        @JvmStatic
        fun test2() {
            println("test2")
        }
    }
}