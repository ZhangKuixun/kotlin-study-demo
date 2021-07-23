package com.kevin.kotlin13

/**
 * other：Kevin
 * create time：2021/7/18
 * describe：
 * 函数组合
 */
fun <A, B, C> myCompose(f: (B) -> C, g: (A) -> B): (A) -> C {
//    return { x: A -> g(x) }//x看做A，调用g写成g(x)
//    return { x: A -> f(g(x)) }//把g作为f的输入，写成f(g(x))
    return { x -> f(g(x)) }
}

/**
 * 函数的泛型<A, B, C>，myCompose方法有两个参数f、g，f、g都是函数对象，f传入B类型返回C结果，g传入A类型返回B结果，
 * myCompose方法的返回结果是一个函数对象，它传入A类型返回C类型。
 * 从myCompose方法的参数g开始看，g传入A返回B，把g的执行结果B作为f的输入，得到C。接着把g的输入作为myCompose方法
 * 最后结果的输入，把f的输出作为myCompose方法最后结果的输出。
 */

fun isEven(x: Int) = 0 == x % 2

fun length(s: String) = s.length

fun main() {
    val evenLength = myCompose(::isEven, ::length)
    val strings = listOf("hello", "java", "kotlin", "C#", "android")
    println(strings.filter(evenLength))//[java, kotlin, C#]
}
