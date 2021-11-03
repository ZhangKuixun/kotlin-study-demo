package com.kevin.kotlin

/**
 * other：Kevin
 * create time：2021/11/2
 * describe：
 * 构造方法:（新的方式）
 */
class Student(
    private val username: String,//加private是属性，不加private是参数
    private val age: Int,
    private var address: String
) {
    fun printInfo() {
        println("username: $username, age: $age, address: $address")
    }
}

/**
 * 构造函数拥有注解或可见性修饰符，不能省略constructor，写在修饰符后面。
 */
class Student2 private constructor(username: String) {
}

/**
 * 默认值
 * 在JVM上，主构造函数的有参数，kotlin编译器会生成无参构造函数，无参构造函数会调用主构造函
 * 数的参数默认值。原因：适配其他的框架，如：spring，对接kotlin代码，调用的是无参构造函数。
 */
class Student3(val username: String = "zhangsan") {
}

fun main() {
    val student = Student("zhangsan", 20, "shenzhen")
    student.printInfo()// username: zhangsan, age: 20, address: shenzhen

    val student3 = Student3("test")
    println(student3.username)
}