package com.kevin.coroutines

/**
 * other：Kevin
 * create time：2021/7/25
 * describe：
 * kotlin的lambda表达式带参数和不带参数的写法：
 * 有参数的lambda类型的函数和没有参数的lambda类型的函数写法完全一样。因为，在kotlin中，调用只有一
 * 个参数的lambda类型的，可以省略参数传递。
 */

fun test(x: Int, action: () -> Unit) {
}

/**
 * 真正在执行时，每次都会给test2的action参数传入一个整数。
 */
fun test2(x: Int, action: (Int) -> Unit) {
}

fun test3() {

}

fun test4(x: Int) {

}

fun test5(x: Int, action: (Int, Int) -> Unit) {
    action(1, 2)
}

fun test6(x: Int, y: Int) {
    println(x + y)
}

fun main() {
    test(5, action = {
        println("hello world")
    })

    // 真正在执行时，每次都会给test2的action参数传入一个整数。这种写法只限于lambda类型的参数
    // 只接收一个参数。
    test2(5, action = {
        println(it)
        println("hello world")
    })
    // 编译报错：期待两个Int类型的参数
//    test5(5, action = {
//    })

    test(5, ::test3)
    test2(5, ::test4)

    // 把test6的方法引用传递给test5的action参数
    test5(5, ::test6)
}