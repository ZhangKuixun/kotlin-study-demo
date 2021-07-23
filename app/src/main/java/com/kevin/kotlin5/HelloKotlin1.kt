package com.kevin.kotlin5

/**
 * other：Kevin
 * create time：2021/6/28
 * describe：
 * 默认参数（default arguments）
 * 在kotlin中调用java方法时，不能使用具名参数语法，因为java字节码不会总是保留方法的参数信息。★★★
 */
fun test(a: Int = 0, b: Int = 1) = println(a - b)

/**
 * 假如，在函数中有两个参数，有默认值在无默认值的前面，只能通过具名参数的方式来调用函数。★★★
 * 具名参数：调用的时候需要把参数名字也写上，比如：test2(b = 2)。
 */
fun test2(a: Int = 1, b: Int) = println(a - b)//-1

/**
 * 如果最后一个参数是一个lambda表达式，上面的规则就可以打破，不需要为lambda写具名参数名，比如：test3(...)★★★
 *
 * 调用：
 * test3(2, 3, ::test)//-1
 * test3(2, 3, { a, b -> println(a - b) })//-1
 * test3(2, 3) { a, b -> println(a - b) }//-1
 * 如果方法的最后一个参数是一个lambda表达式，这个lambda表达式既可以按照参数的形式放在小括号中，也可以直接放到括方法执行体中，
 * 就是在括号后面的花括号里面。
 */
fun test3(a: Int = 1, b: Int = 2, compute: (x: Int, y: Int) -> Unit) {
    compute(a, b)
}

/**
 * 具名参数
 * 在调用函数时，函数参数可以是具名的，使用场景：当一个函数拥有大量参数或是一些参数拥有默认值时。★★★
 */
fun test4(a: Int, b: Int = 2, c: Int = 3, d: Int) = println(a + b + c + d)

/**
 * 在调用函数时，如果同时使用了位置参数与具名参数，所有的位置参数都必须要位于第一个具名参数之前。★★★
 * 比如：foo(1, x=2)是允许的；foo(x=1, 2)是不允许的；
 */

fun test4(vararg str: String) {
    str.forEach { println(it) }
}

/**
 * 子类重写父类的方法，这个方法有默认值的参数，子类重写这个方法时，必须要将默认参数值省略掉，
 * 但是重写的方法中会隐式的使用父类的默认参数值。
 */
open class A {
    open fun method(a: Int, b: Int = 4) = a + b
}

class B : A() {
    override fun method(a: Int, b: Int) = a + b
}


fun main() {
    test()//-1
    test(2)//1
    test(b = 2)//具名参数 -2
    test(3, 2)//1
    test(a = 3)//2

    println("-----------")
    println(A().method(1))//5
    println(B().method(2))//6

    println("-----------")
    test2(b = 2)//-1

    println("-----------")
    test3(2, 3, ::test)//-1
    test3(2, 3, { a, b -> println(a - b) })//-1
    test3(2, 3) { a, b -> println(a - b) }//-1
    test3(2) { a, b ->
        println(a - b)//0
    }
    test3 { a, b -> println(a - b) }//-1

    println("-----------")
    test4(1, 2, 3, 4)//10
    test4(a = 1, b = 2, c = 3, d = 4)//10
    test4(a = 1, d = 5)//11

    println("-----------")
    test4("a", "b", "c")//a b c
    // 可变参数可以借助分散运算符（spread operator）以具名参数的形式传递。
    // 散运算符：数组变量前面有一个星号，它可以把数据打散。
    test4(str = *arrayOf("e", "f", "g"))//e f g
    val arrays = arrayOf("h", "i", "j")
    test4(*arrays)//h i j
}