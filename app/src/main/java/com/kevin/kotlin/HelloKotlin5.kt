package com.kevin.kotlin

/**
 * other：Kevin
 * create time：2021/6/20
 * describe：
 */
fun main() {
    val thePerson = ThePerson("shanghai", "zhangsan")
    println(thePerson.age)
    println(thePerson.address)
    println(thePerson.name)

    println("-------------")

    val theClass = TheClass()
    theClass.init()
    theClass.print()
}


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


// 延迟属性 lateinit
// Kotlin要求非空类型的属性必须在构造方法中进行初始化
// 有时这种要求不方便，比如可以通过依赖注入或是单元测试情况下，对属性赋值
//
// 通过lateinit关键字标识属性为延迟初始化，需要满足三个条件：
// 1.lateinit 只能用在类体中申明的var属性上，不能用在primary constructor的属性申明
// 2.属性不能有自定义的get和set方法
// 3.属性类型要为非空，不能是原生数据类型
//      原生数据类型: - lateinit var name: Int
class TheClass {
    lateinit var name: String

    fun init() {
        this.name = "zhangsan"
    }

    fun print() {
        println(this.name)
    }
}



/*
* 可见性 visibility
* Kotlin提供了四种可见性修饰符：private, protected, internal, public
* protecte不能用在顶层方法、函数中
*
* */

fun method(){

}

class Clazz