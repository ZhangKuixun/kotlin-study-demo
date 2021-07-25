package com.kevin.coroutines

/**
 * other：Kevin
 * create time：2021/7/25
 * describe：
 * kotlin的lambda表达式带参数和不带参数的写法：
 */
fun test(x: Int, action: () -> Unit) {
}

fun test2(x: Int, action: (Int) -> Unit) {
}

fun main() {
    test(5, action = {
        println("hello world")
    })
    test2(5, action = {
        println(it)
        println("hello world")
    })
}
/**
 * 有参数的lambda类型的函数和没有参数的lambda类型的函数写法完全一样。因为，在kotlin中，调用只有一
 * 个参数的函数，可以省略传递的参数。
 *
 * fun test2(x: Int, action: (Int) -> Unit) {
 * }
 * test2(5, action = {
 *     println("hello world")
 * })
 * 真正在执行时，每次都会给test2的action参数传入一个整数。
 */