package com.kevin.kotlin2


/**
 * other：Kevin
 * create time：2021/6/22
 * describe：
 * 分析in、out
 * kotlin中：Consumer用in，Producer用out
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
