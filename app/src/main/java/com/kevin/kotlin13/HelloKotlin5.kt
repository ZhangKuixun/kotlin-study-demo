package com.kevin.kotlin13

/**
 * other：Kevin
 * create time：2021/7/18
 * describe：
 * 属性引用(property Reference)
 * 用法和函数引用的写法一模一样。写法"::属性"
 * 方法来说，两个冒号表示一个函数类型的值。
 *
 */
//const val a = 3
//
//fun main() {
//    println(::a)//val a: kotlin.Int
//    println(::a.get())//3
//    println(::a.name)//a
//}
/**
 * 常量：
 * ::a表示类型KProperty<Int>的属性对象。可以用get获取属性对象的值(::a.get())，或者用name获取属性对象的名字(::a.name)。
 * KProperty：代表一个属性，用val、var声明，用"::"可以获取KProperty类。
 *
 * ::a.get()是在KProperty0的，KProperty0继承了KProperty，KProperty0代表一个没有任何接受者的属性，
 * 比如声明在文件里或者是拥有一个接收者，绑定到接收者上面的。
 * ::a.name是定义在KCallable中，KProperty继承了KCallable，代表一个可调用的实体，比如一个函数或者一个属性，
 * name:声明的属性名字，如果callable没有名字，KCallable会创建一个名字，没有名字的情况：1.构造方法有"init"；
 * 2.属性访问器：比如"foo"属性的get方法"get-foo"，set方法"set-foo"。
 */

var b = 5
fun main() {
    ::b.set(10)
    println(::b)//var b: kotlin.Int
    println(::b.get())//10
    println(::b.name)//b

}
/**
 * 变量：
 * ::b返回的是KMutableProperty<Int>的值，它拥有一个set方法。
 * KMutableProperty继承了KProperty，KMutableProperty表示一个用var声明的属性。
 *
 */