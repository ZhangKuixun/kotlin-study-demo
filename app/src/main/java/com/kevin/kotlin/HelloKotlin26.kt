package com.kevin.kotlin

/**
 * other：Kevin
 * create time：2021/6/20
 * describe：
 * 扩展的作用域
 * 扩展的定义
 *   1.扩展函数定义在某个类，这个类实列叫做分发接收者（dispatch receiver）
 *   2.扩展函数所扩展的目标类，这个类实例叫做扩展接收者（extension receiver）
 *
 * 扩展的作用域
 *   1.在分发接收者，定义了一个扩展函数，在这个扩展函数中可以访问扩展接收者的函数，也可以访问分发接收者的成员。
 *   2.在分发接收者的函数中，可以调用在本类中定义的扩展函数。
 *   3.当分发接收者或者扩展接收者里的成员名字冲突时，扩展接收者的优先级最高。
 *   3.1.如果想要调用自己的函数名，写法：this@EE.tos()。
 */

//扩展接收者
class DD {
    fun method() {
        println("DD method")
    }

    fun tos() {
        println("DD fun")
    }
}

//分发接收者
class EE {
    fun method2() {
    }

    fun DD.hello() {
        method()
        method2()
    }

    fun world(dd: DD) {
        dd.hello()
    }

    fun tos() {
        println("EE fun")
    }

    fun test() {
        DD().output()
    }

    fun DD.output() {
        tos()
        this@EE.tos()
    }
}

fun main() {
    EE().world(DD())// DD method

    EE().test()
    //DD fun
    //EE fun
}

/**
 * 扩展的作用
 *   解决Java中充斥的各种辅助类问题，比如列表的交换方法，必须要把列表传进辅助类里，在辅助类里排序
 * 语法改进：
 *   Java原语法：Collections.swap(list, 4, 10)
 *   kotlin改进语法：list.swap(4, 10)
 */
