package com.kevin.kotlin8

import java.lang.Integer.parseInt
import java.lang.NumberFormatException

/**
 * other：Kevin
 * create time：2021/7/16
 * describe：
 * 异常
 * kotlin的try是一个表达式，不用return，自动取try最后一行的值或者catch最后一行的值。
 * kotlin没有非运行时异常（checked exception）。java有非运行时异常，必须要用try-catch避免错误。
 */
fun main() {
    val s = "3"
    val result: Int? = try {
        parseInt(s)
    } catch (ex: NumberFormatException) {
        null
    } finally {
        println("finally invoked")
    }
    println(result)//finally invoked   3
}