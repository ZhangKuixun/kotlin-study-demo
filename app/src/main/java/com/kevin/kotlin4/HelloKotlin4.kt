package com.kevin.kotlin4

import kotlin.properties.Delegates


/**
 * other：Kevin
 * create time：2021/6/27
 * describe：
 * 非空属性：适用于无法在初始化阶段就确定属性值的情况
 */

class MyPerson {
    var address: String by Delegates.notNull()
}

fun main() {
    val myPerson = MyPerson()
    myPerson.address = "suzhou"
    println(myPerson.address)//suzhou
}
/**
 * Delegates.notNull
 * 针对读写属性返回一个非空的属性委托，它不会在对象构建期间初始化，是在后面的时间初始化。使用的时候必须先赋值，后使用，不然会抛出异常。
 */

