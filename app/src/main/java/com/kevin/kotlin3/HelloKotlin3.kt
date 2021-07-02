package com.kevin.kotlin3

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

val multiply: (Int, Int) -> Int = { a, b -> a * b }//冒号后面是类型，等号后面是值
val add: (Int, Int) -> Int = { a, b -> a + b }
val subtract = { a: Int, b: Int -> a - b }//推断类型
val myAction = { println("hello world") }//返回Unit

val mayReturnNull: (Int, Int) -> Int? = { _, _ -> null }//返回值为空

val functionMaybeNull: ((Int, Int) -> Int)? = null//整个函数类型都可能为null