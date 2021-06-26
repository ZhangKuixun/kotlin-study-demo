package com.kevin.kotlin2

/**
 * other：Kevin
 * create time：2021/6/26
 * describe：
 */
////////////////////////////////////////////////////////////////////////////////////////////////////
// 嵌套类
class OuterClass {
    private val str: String = "hello world"

    class NestedClass {
        fun nestedMethod() = "welcome"
    }
}

//fun main() {
//    println(OuterClass.NestedClass().nestedMethod())
//}


////////////////////////////////////////////////////////////////////////////////////////////////////
// 内部类
class OuterClass2 {
    private val str: String = "hello world"

    inner class InnerClass {
        fun innerMethod() = this@OuterClass2.str
    }

    // 局部嵌套类
    fun getName(): String {
        class LocalNestedClass {
            val name: String = "mytest"
        }

        val localNestedClass = LocalNestedClass()
        return localNestedClass.name
    }
}

//fun main() {
//    println(OuterClass2().InnerClass().innerMethod())
//
//    println(OuterClass2().getName())
//}

/**
 * 嵌套类和内部类的区别：
 * 1.嵌套类：就相当于静态内部类，嵌套类里面的成员是普通的成员
 * 2.内部类：就相当于普通的内部类，创建的时候，需要先创建外部类的实例，再创建内部类，内部类的成员都是普通成员
 *      当创建好了外部类实例的时候，内部类会持有外部类的引用
 */


////////////////////////////////////////////////////////////////////////////////////////////////////
// 实践内部类和嵌套类
class Person1(val name: String, var age: Int) {
    private val str: String = "Person1属性"

    private inner class PersonFeature(var height: Int, var weight: Int) {
        private val str: String = "PersonFeature属性"

        fun getPersonFeature() {
            val str: String = "局部变量"

            println("身高：$height, 体重：$weight")

            println(this@Person1.str)
            println(this.str)
            println(str)

            this@Person1.method()
        }
    }

    private fun method() {
        println("执行了Person的method方法")
    }

    fun getPerson1() {
        val personFeature = PersonFeature(12, 10)
        personFeature.getPersonFeature()
    }
}

//fun main() {
//    val person1 = Person1("张三", 20)
//    person1.getPerson1()
//}
/**
 * 访问外部类的成员：this@外部类名字.str
 * 访问内部类的成员：this.str
 * 方法方法自己的成员：str
 */


////////////////////////////////////////////////////////////////////////////////////////////////////
// 嵌套类只能访问嵌套类，本质就是，非静态的能访问一切，静态只能访问静态
class OuterClass3 {
    private val str: String = "hello world"

    class NestedClass {
        fun nestedMethod() = "welcome"
    }

    class NestedClass2 {
        fun nestedMethod() = NestedClass()
    }
}
