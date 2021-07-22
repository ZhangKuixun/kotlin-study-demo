package com.kevin.kotlin

/**
 * other：Kevin
 * create time：2021/7/22
 * describe：
 * override
 */
open class Fruit {
    open fun name() {
        println("fruit")
    }

    // 如果一个类的方法不想被覆盖，可以用final修饰方法名
    final fun expirationDate() {
        println("1 month")
    }
}

class Apple : Fruit() {
    override fun name() {
        println("apple")
    }

//    override fun expirationDate(){//编译报错
//    }
}

fun main() {
    val apple = Apple()
    apple.name()//apple
    apple.expirationDate()//1 month
}
