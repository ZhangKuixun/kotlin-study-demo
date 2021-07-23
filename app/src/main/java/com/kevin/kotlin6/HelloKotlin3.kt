package com.kevin.kotlin6

/**
 * other：Kevin
 * create time：2021/7/3
 * describe：
 * 闭包★★★
 * 可以访问自己作用域外层的成员。
 */
fun main() {
    var sum = ""

    val strings = arrayOf("hello", "world", "java")
    strings.filter { it.length > 3 }.forEach {
        sum += it
    }
    println(sum)//helloworldjava
}
/**
 * java中，lambda表达式和匿名函数可以访问到自己外层的变量，这些变量不能被修改。
 * kotlin中，只要在闭包中能访问的变量，是可以被修改的。
 */

