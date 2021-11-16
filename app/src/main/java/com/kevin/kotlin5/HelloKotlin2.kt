package com.kevin.kotlin5

/**
 * other：Kevin
 * create time：2021/6/29
 * describe：
 * 可变参数
 */
fun myPrint(name: String): Unit {
    println(name)
}

// 单表达式函数，Kotlin的类型可以通过类型推断判断出来，返回类型可以省略掉
fun add(a: Int, b: Int) = a + b

/**
 * 显示返回类型：
 * 拥有方法体的函数必须指定返回类型，除非函数返回Unit，就是花括号内的代码，才是方法体，没有花括号，就是表达式。
 * Kotlin并不会推断有方法体的函数的返回值，应为逻辑太复杂，对编译器来说太难了。
 */

/**
 * 可变参数
 * 一个方法中，只允许一个参数为可变参数（vararg），通常他是作为最后一个参数。
 * 如果vararg不是最后一个参数，那么它后面的参数，需要用具名参数的形式进行传递。
 * 如果vararg后面的参数是函数类型，函数可以放在圆括号外，用传递lambda表达式。
 */
fun <T> convert2List(vararg elements: T): List<T> {
    val result = ArrayList<T>()
    elements.forEach { result.add(it) }
    return result
}

fun main() {
    println(convert2List("hello", "world", "hello world"))//[hello, world, hello world]

    val elements = arrayOf("welcome", "bye", "test")
    println(convert2List("zhangsan", "lisi", *elements))//[zhangsan, lisi, welcome, bye, test]
}