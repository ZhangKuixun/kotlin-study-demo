package com.kevin.kotlin2

/**
 * other：Kevin
 * create time：2021/6/21
 * describe：
 *
 * data class 数据类
 *
 * 数据类要满足如下要求：
 *   1.主构造方法至少要有一个参数
 *   2.所有的主构造方法参数都需要被标记为var或var，不标记，只是一个参数，不是属性
 *   3.数据类不能是抽象的、open的、sealed的、inner的
 *
 * 对于数据类，编译器会自动生成：
 *   1.equals/hashCode对
 *   2.toString()方法，形式：Person(name=..., age=..., address=...)
 *   3.针对属性的componentN方法，并且是按照属性的声明顺序来生成的
 *
 * 关于数据类成员的继承要点：
 *   1.如果数据类中显示定义了equals、hashCode、toString方法，或者是在数据类的父类中，将这些方法申明成了final，
 *   编译器不会再生成这些方法，编译器使用已有的。
 *   2.如果父类拥有了componentN方法，并且是open的，以及返回兼容的类型，编译器会在数据类中生成相应的componentN方法，
 *   并且重写了父类这些方法；如果父类中的componentN方法由于不兼容的签名或是被定义为final的，编译器会报错。
 *   3.在数据类中显示提供componentN方法以及copy方法，是不允许的，编译器报错。
 *
 * copy方法：必须写需要修改的属性名
 *
 * 解构声明
 *   1.在主构造函数中有多少个参数，就会依次生成对应的component1、component2、component3...，
 *   这些方法返回的就是对应的字段值，componentN方法是用来实现解构声明的。
 *   2.写结构，必须要按顺序把所有的参数都写出来
 *
 * 创建无参构造方法
 *   kotlin中，如果想要编译器生成无参构造方法，必须为所有属性指定默认值。
 */

fun main() {
    val person = Person("zhangsan", 20, "beijing")
    println(person)

    person.age = 30
    println(person.age)

    // copy方法：必须写需要修改的属性名
    val copy = person.copy(address = "hangzhou")
    println(copy)

    val (name, age, address) = person
    println("$name,$age,$address")
}

data class Person(val name: String, var age: Int, var address: String)

data class Person2(val name: String = "", var age: Int = 20, var address: String = "sichuan")


