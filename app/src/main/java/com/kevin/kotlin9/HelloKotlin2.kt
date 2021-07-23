@file:JvmName("NewName")

package com.kevin.kotlin9

import kotlin.reflect.KClass


/**
 * other：Kevin
 * create time：2021/7/16
 * describe：
 * 注解的构造方法，可以接收参数。
 *
 * 构造方法接收的参数类型：
 * 1.与Java原生类型所对应的类型(Int, Long...)
 * 2.字符串
 * 3.class（MyClass::class）
 * 4.枚举
 * 5.其他的注解
 * 6.上面类型的数组类型
 *
 */
annotation class MyAnnotaion2(val str: String)

@MyAnnotaion2("hello")
class MyClass4


annotation class MyAnnotation3(val str: String, val myAnnotaion2: MyAnnotaion2)

@MyAnnotation3("hello", MyAnnotaion2("hello"))
class MyClass5

/**
 * Kotlin注解的构造方法的参数，不支持可空类型，JVM不支持存储null的注解属性值。
 * 如果注解当做其他注解的参数，参数写的注解名字没有@符号。
 */


annotation class MyAnnotation4(val arg1: KClass<*>, val arg2: KClass<out Any>)

@MyAnnotation4(String::class, Int::class)
class MyClass6

/**
 * 如果将class作为注解的参数，参数的值用KotlinClass(KClass)，写法："::class"，Kotlin编译器自动转为JavaClass。
 */


class MyClass7(@field:MyAnnotation val arg1: String,// 注解Java field
               @get:MyAnnotation val arg2: String,// 注解Java getter
               @param:MyAnnotation val arg3: String)// 注解Java构造方法参数

/**
 * 注解的使用处目标（use-sit target）
 * 对类的属性或主构造方法的参数声明注解时，会存在多个java元素可以通过对应的kotlin元素生成出来，
 * 在生成的java字节码中会有多个可能的位置生成相应的注解。想精确指定如何生成注解，使用注解的使用处目标方式来实现。
 *
 * 可以注解类文件，写在整个文件的第一行。
 * @file:JvmName("NewName")
 * 表示最终编译生成的字节码，用括号里的名字"HelloKotlin2"，不是原文件名的名字"HelloKotlin2.kt"。
 *
 * kotlin的注解和java的注解完全兼容。
 */











