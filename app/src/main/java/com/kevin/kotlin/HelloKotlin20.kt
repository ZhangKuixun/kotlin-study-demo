package com.kevin.kotlin

/**
 * other：Kevin
 * create time：2021/6/20
 * describe：
 */
// 属性
class ThePerson(address: String, name: String) {
    val age: Int
        get() = 20

    // 1.给属性赋的值，叫做初始器，等号+等号右边的值，“= address”就是初始器
    // 2.属性的get和set方法默认提供，他们被省略了的
    // 3.属性背后真正保存值的是 field 字段，field字段是系统编译时创建，field字段只能在get、set（访问器）中才能被使用
    // 4.自己写set，不能直接把值赋给变量，而是赋值给field，field也叫做幕后字段，只能在get、set才能使用
    var address: String = address
        get() {/*访问器*/
            println("get invoked")
            return field
        }
        set(value) {/*访问器*/
            println("set invoked")
            field = value
        }

    var name: String = name
}

fun main() {
    val thePerson = ThePerson("shanghai", "zhangsan")
    println(thePerson.age)//20

    println("---------")
    println(thePerson.address)//get invoked   shanghai
    thePerson.address = "tianjing"//set invoked
    println(thePerson.address)//get invoked   tianjing

    println("---------")
    println(thePerson.name)//zhangsan
    thePerson.name = "lisi"
    println(thePerson.name)//lisi
}