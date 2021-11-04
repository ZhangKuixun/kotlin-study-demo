package com.kevin.kotlin

/**
 * other：Kevin
 * create time：2021/6/20
 * describe：
 * 对可空类型扩展，可空类型：一个类型后面加一个问号
 */
fun Any?.toString(): String {
    if (null == this)
        return "null"
    return toString()
}

/**
 * 扩展属性
 */
class MyExtensionProperty

val MyExtensionProperty.name: String
    get() = "hello"

fun main() {
    val myExtensionProperty = MyExtensionProperty()
    println(myExtensionProperty.name)//hello

    CompanionObjectExtension.method()//hello world
}

/**
 * 扩展伴生对象
 */
class CompanionObjectExtension {
    companion object MyObject {}
}

fun CompanionObjectExtension.MyObject.method() {
    println("hello world")
}