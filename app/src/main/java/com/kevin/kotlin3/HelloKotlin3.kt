package com.kevin.kotlin3

import java.lang.StringBuilder

/**
 * other：Kevin
 * create time：2021/7/1
 * describe：
 */
////////////////////////////////////////////////////////////////////////////////////////////////////
// 高阶函数（high-order function）与lambda
/**
 * Lambda表达式格式要求：
 * 1.一个lambda表达式必须被一对花括号所包围。
 * 2.如果有参数，参数位于箭头(->)之前，参数类型可以省略。
 * 3.执行体位于箭头之后。
 *
 * 在kotlin中，如果一个函数的最后一个参数是函数，可以将lambda作为参数，传递到函数中，并且lambda可以写在圆括号外面。
 */

val multiply: (Int, Int) -> Int = { a, b -> a * b }//冒号后面是类型，等号后面是值（常用）
val add: (Int, Int) -> Int = { a, b -> a + b }
val subtract = { a: Int, b: Int -> a - b }//推断类型（常用）
val myAction = { println("hello world") }//返回Unit

val mayReturnNull: (Int, Int) -> Int? = { _, _ -> null }//返回值为空

val functionMaybeNull: ((Int, Int) -> Int)? = null//整个函数类型都可能为null


////////////////////////////////////////////////////////////////////////////////////////////////////
// 高阶函数
/**
 * 高阶函数（high-order function）
 * 定义一个函数，其中一个参数也是一个函数。
 */
fun myCalculate(a: Int, b: Int, calculate: (Int, Int) -> Int): Int {
    return calculate(a, b)
}

/**
 * 分析：myCalculate有三个参数，参数1和参数2，参数3是一个函数，这个函数可以传入两个Int型的参数，返回一个Int型的值，
 * myCalculate整个函数返回一个Int值。
 */

//fun main() {
//    println(myCalculate(2, 3) { x, y -> x + y })//5
//    println(myCalculate(2, 3) { x, y -> x - y })//-1
//    println(myCalculate(2, 3) { x, y -> x * y })//6
//}


////////////////////////////////////////////////////////////////////////////////////////////////////
// 把string字符串列里面的数字过滤掉
const val s = "abc2def9xy7"
fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()
    for (index in 0 until length) {
        val element = get(index)
        if (predicate(element)) {
            sb.append(element)
        }
    }
    return sb.toString()
}

fun main() {
//    val compile = Pattern.compile("[^a-zA-Z]")
//    println(compile.matcher(s).replaceAll(""))
    s.filter { it.isLetter() }
}



