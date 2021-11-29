package com.kevin.kotlin6

/**
 * other：Kevin
 * create time：2021/7/3
 * describe：
 * 匿名函数
 */
fun main() {
    // 1.匿名函数只能声明在函数里面，匿名函数写在外面，他没有名字，没法使用。
    // 2.把匿名函数放在函数里面，对匿名方法做一些转换，让后面的代码可以使用。
    fun(x: Int, y: Int) = x + y
    fun(x: Int, y: Int): Int {
        return x + y
    }

    // 匿名函数主要在lambda表达式中使用。
    val string = arrayOf("hello", "world", "lambda")
    string.filter(fun(item): Boolean = item.length > 3).forEach(fun(item) { println(item) })
}
/**
 * 匿名函数和lambda表达式的区别：
 * 1.匿名函数可以自动推断返回类型。
 * 2.匿名函数的执行体是一个花括号，必须显示指定返回值。
 * 3.匿名函数的参数写在圆括号里面；普通方法最后一个参数是一个lambda，它可以写到圆括号外面。
 * 4.匿名函数用return，返回匿名函数本身；lambda里面用return，返回lambda外层函数。
 */