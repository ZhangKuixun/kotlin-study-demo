package com.kevin.kotlin6

/**
 * other：Kevin
 * create time：2021/7/4
 * describe：
 * 带接收者函数字面值
 *
 * 在声明或者定义一个函数时，可以指定这个函数是被哪一个类或哪一个函数使用。
 *
 * kotlin提供了一个功能：可以通过指定的接收者对象来调用一个函数字面值，
 * 在函数字面值内部，你可以调用接收者对象的方法，不用使用额外的修饰符，这一点非常类似于扩展函数。
 */
fun main() {
    val subtract: Int.(other: Int) -> Int = { other -> this - other }
    println(1.subtract(3))//-2
    /**
     * 分析：
     * "val subtract:"是变量subtract。
     * "Int.(other: Int) -> Int = { other -> this - other }"是类型，表示函数类型。
     * "Int."表示点后面的内容是Int类的函数。
     * "Int.(other: Int)" other是传入的参数，是Int类型的变量。
     * "Int.(other: Int) -> Int"返回类型是箭头后面的Int。
     * "{ other -> this - other }"是函数体。
     * "other -> this - other"这里的this表示的是"Int."，谁调用了当前这个函数，this就指向谁。
     * 只有Int可以去调用这个函数。
     */

    println("------------------")
    // 匿名函数 + 函数字面值
    val sum = fun Int.(other: Int): Int = this + other
    println(1.sum(2))//3
    /**
     * 匿名函数语法可以让我们指定函数字面值的接收者。
     * 我们可以去先声明一个带有字面接收者类型的函数变量，然后再去使用它。
     */

    println("------------------")
    // 带有接收者类型的函数的非字面值可以作为参数进行传递，前提是所需要接收函数的地方应该有一个接收者类型的参数，反之也可以。
    // 比如：String.(Int) -> Boolean 与 (String, Int) -> Boolean 等价。
    val myEquals: String.(Int) -> Boolean = { param -> this.toIntOrNull() == param }
    println("345".myEquals(345))//true

    println("------------------")
    fun myTest(op: (String, Int) -> Boolean, a: String, b: Int, c: Boolean) = println(op(a, b) == c)
    myTest(myEquals, "200", 200, true)//true
    /**
     * 分析：
     * myEquals传入myTest，执行myTest函数体的op，op指向的是传入的myEquals
     */
}