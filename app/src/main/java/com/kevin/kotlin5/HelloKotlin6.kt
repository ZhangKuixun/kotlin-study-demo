package com.kevin.kotlin5

/**
 * other：Kevin
 * create time：2021/7/1
 * describe：
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

fun main() {
    println(myCalculate(2, 3) { x, y -> x + y })//5
    println(myCalculate(2, 3) { x, y -> x - y })//-1
    println(myCalculate(2, 3) { x, y -> x * y })//6
}