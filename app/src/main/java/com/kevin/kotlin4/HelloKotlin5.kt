package com.kevin.kotlin4

import kotlin.properties.Delegates


/**
 * other：Kevin
 * create time：2021/6/27
 * describe：
 * 可观测属性（Observable）
 */
class Person {
    var age: Int by Delegates.observable(20) { prop, oldValue, newValue ->
        println("${prop.name}, oldValue: $oldValue, newValue: $newValue")
    }
}

class Person2 {
    var age: Int by Delegates.vetoable(20) { property, oldValue, newValue ->
        when {
            oldValue <= newValue -> true
            else -> false
        }
    }
}

fun main() {
    val person = Person()
    person.age = 30//age, oldValue: 20, newValue: 30
    person.age = 40//age, oldValue: 30, newValue: 40

    println("----------")

    val person2 = Person2()
    println(person2.age)//20
    println("--")
    person2.age = 40
    println(person2.age)//40
    println("--")
    person2.age = 30
    println(person2.age)//40
}

/**
 * Delegates.observable(initialValue, onChange): ReadWriteProperty
 * 返回了一个针对读写属性的委托，当属性值被改变之后，调用回调函数。
 * initialValue: 属性的初始值
 * onChange：是一个回调函数，它是在属性变化之后被调用。
 * --onChange的三个参数：属性名字，旧的属性值，新的属性值。
 * ReadWriteProperty: 是Delegates.observable的返回值，就是一个属性委托，里面有getValue、setValue方法。
 *
 * Delegates.vetoable(initialValue, onChange): ReadWriteProperty
 * 返回了一个针对读写属性的委托，当属性值被改变之前，调用回调函数，回调允许否决这个修改。
 * onChange：对属性值修改之前调用回调函数。
 * 当回调被调用的时候，属性值还尚未被修改，如果返回true，就会被设置成新的值，如果返回false，设置的值不会修改属性。
 *
 */
