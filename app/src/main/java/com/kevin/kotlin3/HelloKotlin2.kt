package com.kevin.kotlin3

/**
 * other：Kevin
 * create time：2021/6/29
 * describe：
 */
fun myPrint(name: String): Unit {
    println(name)
}

// 单表达式函数，Kotlin的类型可以通过类型推断判断出来，返回类型可以省略掉
fun add(a: Int, b: Int) = a + b

/**
 * 指定返回类型的函数：
 * 拥有方法体的函数，必须要指定返回类型，就是花括号内的代码，才是方法体，没有花括号，就是表达式。
 * Kotlin并不会推断有方法体的函数的返回值，应为逻辑太赋值，对编译器来说太难了。
 */

/**
 * 可变参数
 * 一个方法中，只允许一个参数为可变参数（vararg），通常他是作为最后一个参数。
 * 如果vararg不是最后一个参数，那么它后面的参数，需要用具名参数的形式进行传递。
 * 如果vararg后面的参数是函数类型，可以通过在在圆括号外传递lambda表达式来实现。
 */
fun <T> convert2List(vararg elements: T): List<T> {
    val result = ArrayList<T>()
    elements.forEach { result.add(it) }
    return result
}

//fun main() {
//    println(convert2List("hello", "world", "hello world"))
//
//    var elements = arrayOf("welcome", "bye", "test")
//    println(convert2List("zhangsan", "lisi", *elements))
//}


////////////////////////////////////////////////////////////////////////////////////////////////////
// 中缀符号
/**
 * 中缀符号（infix notation）
 * 函数还可以通过中缀符号调用，满足下面三个条件：
 * 1.是成员函数或扩展函数，就是要依托于具体的函数或具体的类
 * 2.函数必须只有一个参数
 * 3.用infix关键字申明函数
 */
class infixTest(private var a: Int) {
    infix fun add(b: Int) = this.a + b
}

//fun main() {
//    val infixTest = infixTest(1)
//    //下面两种方式是等价的
//    println(infixTest.add(5))
//    println(infixTest add 5)//中缀调用法
//}

////////////////////////////////////////////////////////////////////////////////////////////////////
// 内联函数
/**
 * 内联函数（inline function）
 *
 * 普通函数：
 * 有两个方法 A、B，A方法中调用了B方法，运行时，会把A当时的一些现场信息存放到栈当中，然后调用B，把B的返回结果再拿回到A的现场，
 * 再把A保存到栈当中的信息，从栈当中弹出来，方法调用本身，会有一点点的性能损耗，可以不计。
 *
 * 内联函数：A方法中调用了B方法，运行时，会把A当时的一些现场信息存放到栈当中，然后调用B，会把B的方法体原封不动的拷贝到A调用B的位置处，
 * 这个称之为内联。
 * 内联函数-缺点：会导致生成的字节码非常大，比如有100个地方调用了B，如果调用都定义成内联，相当于把B的代码拷贝10份，放置到这100个调用处。
 */
inline fun myCalculate(a: Int, b: Int) = a + b

fun main() {
    println(myCalculate(1, 2))
}




