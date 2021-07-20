package com.kevin.kotlin10


/**
 * other：Kevin
 * create time：2021/7/20
 * describe：
 */
class MyTestClass<K, V> {
    var k: K? = null
    var v: V? = null
}

fun main() {
    // 获取泛型类型
    val kClass = MyTestClass::class
    val typeParameters = kClass.typeParameters
    println(typeParameters.size)//2
    println("first type:" + typeParameters[0])//K
    println("first type:" + typeParameters[1])//V
}


