package com.kevin.kotlin2

import android.annotation.SuppressLint

/**
 * other：Kevin
 * create time：2021/6/22
 * describe：
 *
 * generics 泛型，变量类型的参数化
 *
 */

class MyGeneric<T>(t: T) {
    var varible: T

    init {
        this.varible = t
    }
}

/**
 *
 * 泛型中的 协变（covariant）与逆变（controvariant）的概念来源
 *
 * List<String>、List<Object>不相等
 *
 * List<String> list = new ArrayList();
 * List<Object> list2 = list;// 编译失败，假如编译成功
 *
 * list2.add(new Date());// new Date()是Object子类，放入list2中。
 *
 * String str = list.get(0);// 放入list2的是Data()，取出来变成了String了，java不允许。
 *
 * 可以用通配符解决上面的问题。
 * List<? extends Object>，"? extends Object" 限定了类型的上限范围
 *
 *
 * interface Collection<E> {
 *   void addAll(Collection<E> items);// 失败
 * }
 *
 * void copyAll(Collection<Object> to, Collection<String> from) {
 *   to.addAll(from);
 *   // 调用上面的Collection<E>的addAll(Collection<E> items)方法，失败。
 *   // 调用下面的Collection<E>的addAll(Collection<? extends E> items)方法，成功，添加之后把String类型当作Object类型看待。
 * }
 *
 * interface Collection<E> {
 *   void addAll(Collection<? extends E> items);// 成功
 * }
 *
 * Collection<String>不是Collection<Object>的子类型
 * Collection<String>是Collection<? extends Object>的子类型，"? extends Object"规定了上限，只能放入Object以下的类型。----协变
 *
 * List<? super String>，"? super String"规定了下限，只能放入String以及String类型以上的类型。----逆变
 *
 * 只从里面读取数据，不往里面写数据，叫生产者；----协变
 * 只向里面写数据，不从中读取数据，叫消费者。----逆变
 *
 * 生产者使用 ? extends E，消费者使用 ? super E。
 *
 */
//fun main() {
//    val myGeneric = MyGeneric("hello world")// 借助于kotlin的类型推断
//    println(myGeneric.varible)
//
//    println("-------------")
//
//    val myClass = MyClass<String, Number>("abc", 1)
//    myTest(myClass)
//}

class MyClass<out T, in M>(t: T, m: M) {
    private var t: T
    private var m: M

    init {
        this.t = t
        this.m = m
    }

    fun get(): T = this.t

    fun set(m: M) {
        this.m = m
    }
}

fun myTest(myClass: MyClass<String, Number>) {
    // 把String类型的数据写入Any类型，读的时候，读的是Any类型，协变
    // 把Number类型的数据写入Int类型，读的时候，读的是Int类型，逆变
    val myObject: MyClass<Any, Int> = myClass

    println(myObject.get())
}


/**
 * 分析in、out
 * kotlin中：
 *   Consumer用in，Producer用out
 */
fun main() {
    // 协变
    val parameterizedProducer = ParameterizedProducer("welcome")
    val myRef: ParameterizedProducer<Any> = parameterizedProducer
    println(myRef is ParameterizedProducer<Any>)
    // java的写法：
    // List<String> list2 = new ArrayList();
    // List<? extends Object> list = list2;

    println("------------")

    val parameterizedConsumer: ParameterizedConsumer<Number> = ParameterizedConsumer()
    val myRef2: ParameterizedConsumer<Int> = parameterizedConsumer
    println(myRef2 is ParameterizedConsumer<Int>)
    // java的写法：
    // List<Object> list = new ArrayList();
    // List<? super String> list2 = list
}

class ParameterizedProducer<out T>(private val value: T) {
    fun get(): T {
        return this.value
    }
}

class ParameterizedConsumer<in T> {
    fun toString(value: T): String {
        return value.toString()
    }
}


