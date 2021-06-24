package com.kevin.kotlin2

/**
 * other：Kevin
 * create time：2021/6/21
 * describe：
 *
 * sealed class 密封类
 *
 * 密封类和枚举用法相似
 *
 * 怎么定义密封类：
 *   1.在类的前面加上 sealed
 *   2.密封类的直接子类，必须放在在同一个文件中，间接子类可以放在任何地方，可以有很多子类
 *   3.密封类本身是抽象的，有抽象的成员，不能实例化，构造方法本身就是私有的
 *
 *
 *
 */

fun main() {
    println(calculate(1, 2, Add()))// 3
    println(calculate(1, 2, Subtract()))// -1
    println(calculate(1, 2, Multiply()))// 2
}

sealed class Calculator

class Add : Calculator()

class Subtract : Calculator()

class Multiply : Calculator()

fun calculate(a: Int, b: Int, cal: Calculator) = when (cal) {
    is Add -> a + b
    is Subtract -> a - b
    else -> a * b
}

