package com.kevin.kotlin13

/**
 * other：Kevin
 * create time：2021/7/18
 * describe：
 * 通过对象获取KClass对象。
 */
fun main() {
    val son: Parent = Son()
    val daughter: Parent = Daughter()

    println(son::class)//class com.kevin.kotlin10.Son
    println(son::class.java)//class com.kevin.kotlin10.Son
    println("-----------")
    println(daughter::class)//class com.kevin.kotlin10.Daughter
    println(daughter::class.java)//class com.kevin.kotlin10.Daughter
}

open class Parent
class Son : Parent()
class Daughter : Parent()