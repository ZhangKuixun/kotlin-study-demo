package com.kevin.kotlin3

/**
 * other：Kevin
 * create time：2021/6/26
 * describe：
 * 匿名对象类型，满足任意一点即可：
 * 匿名对象里的成员只能在局部变量或被private修饰的成员变量范围内，能访问匿名对象里的成员。
 * 将匿名对象当作public方法的返回类型或public属性的类型，方法的返回类型和属性的类型是父类型。只能访问父类型的成员。
 * 没有声明任何父类型，类型是Any，无法访问匿名对象里的任何成员。
 */
class MyClass1 {
    private var myObject = object {
        fun output() {
            println("output invoked")
        }
    }

    fun myTest() {
        println(myObject.javaClass)//class com.kevin.kotlin3.MyClass1$myObject$1
        println(myObject::class.java)//class com.kevin.kotlin3.MyClass1$myObject$1
        myObject.output()//output invoked
    }
}


// 不是private修饰的成员变量
class MyClass2 {
    private fun method1() = object {
        var str = "hello"
    }

    // 不是private修饰的成员变量
    internal fun method2() = object {
        var str = "world"
    }

    fun test() {
        val str = method1().str
        // val str1 = method2()//编译错误，没有method2()方法
    }
}

fun main() {
    val myClass = MyClass1()
    myClass.myTest()
}