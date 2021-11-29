package com.kevin.kotlin13

import kotlin.reflect.KMutableProperty0
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.KProperty1
import kotlin.reflect.jvm.javaField
import kotlin.reflect.jvm.javaGetter
import kotlin.reflect.jvm.javaSetter

/**
 * other：Kevin
 * create time：2021/7/21
 * describe：
 * 反射对应的java信息
 */
class MyTestClass14 {
    var name = "Java"
    val price = 3.3
}

var myTest = "myTest"

fun main() {
    // 获取包级别属性的支持字段、get方法、set方法
    val topProp: KMutableProperty0<String> = ::myTest
    println(topProp.javaField)//private static java.lang.String com...HelloKotlin26Kt.myTest
    println(topProp.javaGetter)//public static final java.lang.String com...HelloKotlin26Kt.getMyTest()
    println(topProp.javaSetter)//public static final void com...HelloKotlin26Kt.setMyTest(java.lang.String)

    // 获取可读写属性的支持字段、get方法、set方法
    val n: KMutableProperty1<MyTestClass14, String> = MyTestClass14::name
    println(n.javaField)//private java.lang.String com...MyTestClass14.name
    println(n.javaGetter)//public final java.lang.String com...MyTestClass14.getName()
    println(n.javaSetter)//public final void com...MyTestClass14.setName(java.lang.String)

    // 获取只读属性的支持字段、get方法、set方法
    val p: KProperty1<MyTestClass14, Double> = MyTestClass14::price
    println(p.javaField)//private final double com...MyTestClass14.price
    println(p.javaGetter)//public final double com...MyTestClass14.getPrice()
}
/**
 * javaField：当前属性被转移成字节码之后，对应的一个java字段。
 * javaGetter,javaSetter：转换成字节码后的java对应的信息。
 */
