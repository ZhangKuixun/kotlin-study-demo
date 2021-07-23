package com.kevin.kotlin5

/**
 * other：Kevin
 * create time：2021/6/29
 * describe：
 * 内联函数（inline function）
 *
 * 普通函数：
 * 有两个方法 A、B，A方法中调用了B方法，运行时，会把A当时的一些现场信息存放到栈当中，然后调用B，把B的返回结果再拿回到A的现场，
 * 再把A保存到栈当中的信息，从栈当中弹出来，方法调用本身，会有一点点的性能损耗，可以不计。
 *
 * 内联函数：A方法中调用了B方法，运行时，会把A当时的一些现场信息存放到栈当中，然后调用B，会把B的方法体原封不动的拷贝到A调用B的位置处，
 * 这个称之为内联。
 * 内联函数-缺点：会导致生成的字节码非常大，比如有100个地方调用了B，如果调用都定义成内联，相当于把B的代码拷贝10份，放置到这100个调用处。
 */
inline fun myCalculate(a: Int, b: Int) = a + b

fun main() {
    println(myCalculate(1, 2))
}