package com.kevin.kotlin

/**
 * other：Kevin
 * create time：2021/11/1
 * describe：
 * 区间
 */
fun main() {
    区间()
}

fun 区间() {
    val a = 5
    val b = 10
    for (i in a..b) {
        println(i)//5 6 7 8 9 10
    }

    println("--------")

    // 编译报错，不能在for循环中用!in
//    for (i !in a..b) {
//    }

    println("--------")

    for (i in a..b step 2) {
        println(i)//5 7 9
    }

    println("--------")

    for (i in 10 downTo 2 step 4) {
        println(i)//10 6 2
    }
}
