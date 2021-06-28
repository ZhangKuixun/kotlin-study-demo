package com.kevin.kotlin2

import android.view.WindowInsetsAnimationControlListener
import android.view.WindowInsetsAnimationController

/**
 * other：Kevin
 * create time：2021/6/27
 * describe：对象声明
 */

object MyObject {
    fun method() = "hello world"
}

object MyObject2 : WindowInsetsAnimationControlListener {
    override fun onReady(controller: WindowInsetsAnimationController, types: Int) {
        TODO("Not yet implemented")
    }

    override fun onFinished(controller: WindowInsetsAnimationController) {
        TODO("Not yet implemented")
    }

    override fun onCancelled(controller: WindowInsetsAnimationController?) {
        TODO("Not yet implemented")
    }
}

fun main() {
    println(MyObject.method())
}

/**
 * 对象声明和对象表达式的区别：
 * 1.对象表达式是立刻初始化或执行的
 * 2.对象声明是懒加载，在首次访问的时候初始化
 * 3.伴生对象是在其所对应的类被加载时初始化的，类似Java的静态成员初始化
 */