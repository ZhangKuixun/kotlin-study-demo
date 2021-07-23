package com.kevin.kotlin44

/**
 * other：Kevin
 * create time：2021/7/16
 * describe：
 * 范围 Range
 */
fun main() {
    var i = 1
    // 闭区间：包含1和5
    if (i in 1..5) {
        println(i)//1
    }

    println("-------升序")
    //for (int a = 1, a <= 4, a++)
    for (a in 1..4) {
        println(a)//1 2 3 4
    }

    println("-------降序")
    //for (int a = 4, a <= 1, a--)
    for (a in 4..1) {
        println(a)//什么都不输出
    }

    //for (int a = 4, a <= 1, a--)
    for (a in 4 downTo 1) {
        println(a)//4 3 2 1
    }

    println("-------升序，每次跨2步")
    //step后面的值必须是正数
    for (a in 1..6 step 2) {
        println(a)//1 3 5
    }

    println("-------升序，左闭右开")
    for (a in 1 until 4) {
        println(a)//1 2 3
    }
}

/**
 * Range的实现原理：
 * Int有自己的IntRange，继承IntProgression，它表示每一次遍历的过程，还继承了ClosedRange，它表示start、endInclusive、是否包含当前值。
 */