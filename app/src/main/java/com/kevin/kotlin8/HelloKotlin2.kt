package com.kevin.kotlin8

/**
 * other：Kevin
 * create time：2021/7/16
 * describe：
 * 异常：throw
 * kotlin的throw是一个表达式，将throw作为Elvis表达式的一部分。
 *
 * Elvis表达式：
 * 1.和三元运算符类似，但是Elvis的问号和冒号连在一起的（?:）。
 * 2.如果?:前面表达式不为空，返回前面的表达式，如果?:前面表达式为空，返回后面的表达式。
 *
 * throw表达式是Nothing类型(不包含任何值的类型)，只表示代码永远不会到达的位置，不会返回。
 * val str2 = str ?: throw IllegalArgumentException("值不能为空")
 * 如果str=null，throw把异常抛到main方法的外面，报异常，程序终止，不会把值给str2。
 *
 * 写代码时，可以用Nothing标记没有返回值的函数。
 *
 */
fun main() {
    val str: String? = null

    // 如果str=null，throw把异常抛到main方法的外面，不会把值给str，代码就结束了
//    val str2 = str ?: throw IllegalArgumentException("值不能为空")//报错
//    println(str2)

    println("----------------")
//    val str3 = str ?: myMethod("test")

    println("----------------")

    // 可以为Nothing，也可以为null
//    Nothing?

    var s = null
    println(s is Nothing?)//true

    var s2 = listOf(null)
    println(s2 is List<Nothing?>)//true
}

// 写代码时，可以用Nothing标记没有返回值的函数。
fun myMethod(message: String): Nothing {
    throw java.lang.IllegalArgumentException(message)//报错
}