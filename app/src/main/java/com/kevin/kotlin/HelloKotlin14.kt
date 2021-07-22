package com.kevin.kotlin

/**
 * kotlin所有的类都不能被继承，所有的类都是final类型，如果想被继承，在class关键字前面用open修饰。
 */
open class Parent(name: String, age: Int) {
}

class Child(name: String, age: Int) : Parent(name, age) {
    // Child类接收了两个参数，需要显示的传递给父类，Parent(name, age)里面的两个参数
}


/**
 * kotlin中，一个类没有Primary构造方法，还继承了另外一个类，当前类的每个secondary构造方法需要通过supper关键字来初始化父类型，
 * 或者通过调用父类的secondary构造方法，不同的secondary构造方法可以调用父类型不同的构造方法。
 */
open class Parent2(name: String) {}

class Child2 : Parent2 {
    constructor(name: String) : super(name) {
    }
}