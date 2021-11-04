package com.kevin.kotlin

/**
 * other：Kevin
 * create time：2021/6/19
 * describe：
 * object declaration，对象声明
 */
object MyObject {
    // 对象，和类一样
    fun method() {
        println("method")
    }
}

fun main() {
    MyObject.method()//method

    println("---------")
    MyTest.MyObject.method()//method invoked!
    MyTest.method()//method invoked!   类似于静态方法，kotlin中没有静态方法

    println("---------")
    val v = MyTest.MyObject
    println(v.javaClass)//class com.kevin.kotlin.MyTest$MyObject

    println("---------下面的结果一样")
    D.Companion.foo()
    D.Companion.bar()
    D.foo()
    D.bar()
}

/**
 * companion object 伴生对象：随着类的存在而存在，当类使用
 *
 * 在kotlin中，类没有static方法
 * 在大多数情况下，kotlin推荐的做法是使用包级别的函数来作为静态方法
 * kotlin会将包级别的函数当作静态方法来看待
 *
 * 每个类只能有一个伴生对象，伴生对象的名字可以省略，编译器会提供一个默认的名字Companion
 *
 * 注意：虽然伴生对象的成员看起来像Java中的静态成员，在运行期，他们不是静态成员，他们依旧是真实对象的实例成员
 * 在JVM上，可以将伴生对象的成员真正变成类的静态方法与属性，使用@JvmStatic注解来实现
 * 伴生对象在编译后，会变成静态内部类
 */
class MyTest {
    companion object MyObject {
        var a: Int = 100

        fun bar() {
            println("bar")
        }

        @JvmStatic
        fun method() {
            println("method invoked!")
        }
    }
}

class D {
    companion object {
        @JvmStatic
        fun foo() {
        }

        fun bar() {
        }

    }
}

// 调用MyTest里面方法的执行流程：
// MyTest.foo()// 调用MyTest里面的foo静态方法
// MyTest.bar()// 调用MyTest里面的MyObject对象里面的bar实例方法



