package com.kevin.kotlin3

/**
 * other：Kevin
 * create time：2021/6/28
 * describe：
 */
/**
 * 默认参数（default arguments）
 */
fun test(a: Int = 0, b: Int = 1) = println(a - b)

/**
 * 子类重写父类的方法，这个方法有默认值的参数，子类重写这个方法时，必须要将默认参数值省略掉，但是重写的方法中会隐式的使用父类的默认参数值。
 */
open class A {
    open fun method(a: Int, b: Int = 4) = a + b
}

class B : A() {
    override fun method(a: Int, b: Int) = a + b
}

/**
 * 在函数中，如果一个有默认值的参数位于一个无默认值的参数前面，那么只能通过具名参数的方式来调用函数。
 * 具名参数：调用的时候需要把参数名字也写上，比如：test2(b = 3)。
 */
fun test2(a: Int = 1, b: Int) = println(a - b)

/**
 * 如果最后一个参数是一个lambda表达式，上面的规则就可以打破，不需要为lambda形式的参数写具名参数名，比如：test3(...)
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

fun main() {
    test()//-1
    test(2)//1
    test(b = 2)//显示指定参数名 -2
    test(3, 2)//1
    test(a = 3)//2

    println("-----------")

    println(A().method(1))//5
    println(B().method(2))//6

    println("-----------")

    println(test2(b = 2))//6

    println("-----------")

    test3(2, 3, ::test)//-1
    test3(2, 3, { a, b -> println(a - b) })//-1
    test3(2, 3) { a, b -> println(a - b) }//-1

    test3(2) { a, b ->
        println(a - b)//0
    }

    test3 { a, b -> println(a - b) }//-1
}