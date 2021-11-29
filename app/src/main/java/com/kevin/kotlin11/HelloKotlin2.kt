package com.kevin.kotlin11

/**
 * other：Kevin
 * create time：2021/7/16
 * describe：
 * kotlin生成的字节码
 * 在文件中声明(包级别)的函数、变量、方法...，被编译完后，函数、变量、方法等等，都会变成静态成员，
 * 把它们放在当前的文件里面，这个文件的名字就是"类名Kt.class"。
 *
 * 包级别：不在类名中声明对象，直接在文件中声明对象
 *
 * 注意：java类不能用new得到kotlin生成的以Kt结尾的实例，没有生成无参构造方法。☆☆☆
 */
class MyClass

fun test() {
    println("hello world")
}

var str: String = "kotlin"
