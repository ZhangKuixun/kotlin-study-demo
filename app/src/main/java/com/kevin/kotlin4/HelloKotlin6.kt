package com.kevin.kotlin4

import java.util.*

/**
 * other：Kevin
 * create time：2021/6/27
 * describe：
 * map委托
 */
class Student(map: Map<String, Any?>) {
    val name: String by map
    val address: String by map
    val age: Int by map
    val birthday: Date by map
}

class Student2(map: MutableMap<String, Any?>) {
    var address: String by map
}

fun main() {
    val student = Student(
        mapOf(
            "name" to "zhangsan",
            "address" to "beijing",
            "age" to 20,
            "birthday" to Date()
        )
    )
    println(student.name)//zhangsan
    println(student.address)//beijing
    println(student.age)//20
    println(student.birthday)//Sun Jul 11 12:20:08 CST 2021

    println("-----------")

    val map = mutableMapOf<String, Any?>("address" to "beijing")
    val student2 = Student2(map)
    println(map["address"])//beijing
    println(student2.address)//beijing

    println("--")

    student2.address = "shanghai"
    println(map["address"])//shanghai
    println(student2.address)//shanghai
}
/**
 * 将属性存储到map中
 *
 * 一种常见的应用场景是将属性值存储到map当中。
 * 这种通常出现在JSON解析或是一些动态行为。
 * 这种情况中，可以将map实例作为委托，作为类的属性委托。
 *
 * 注意：map中的key，名字要与Student类中的属性名字保持一致。
 */