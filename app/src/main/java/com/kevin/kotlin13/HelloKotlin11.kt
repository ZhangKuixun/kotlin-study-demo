package com.kevin.kotlin13

import kotlin.reflect.KClass

/**
 * other：Kevin
 * create time：2021/7/20
 * describe：
 * KClass对应Class，KFunction对应Method，KProperty对应field
 */

fun main() {
    val kotlinLang = "kotlin"
    val kClass: KClass<out String> = kotlinLang::class
    println(kClass)//class kotlin.String

    println("-----------")
    val kClassDataType: KClass<String> = String::class
    println(kClassDataType)//class kotlin.String

    println("-----------")
    // kotlin中，无论一个类有多少个实例，这些实例只对应同一个KClass对象。
    val kClass1: KClass<out String> = "kotlin"::class
    val kClass2: KClass<out String> = "java"::class
    val kClass3: KClass<out String> = "ruby"::class
    println(kClass1)//class kotlin.String
    println(kClass2)//class kotlin.String
    println(kClass3)//class kotlin.String
    println(kClass1 == kClass3)//true

    println("-----------")
    val kclass4: KClass<out Any> = Class.forName("java.util.Date").kotlin
    println(kclass4)//class java.util.Date
    println(kclass4 == Class.forName("java.util.Date"))//false
    println(kclass4 == Class.forName("java.util.Date").kotlin)//true
}


