package com.kevin.kotlin4


/**
 * other：Kevin
 * create time：2021/6/27
 * describe：
 * 延迟属性：属性在第一次被访问的时候才会被计算，然后将计算的结果缓存起来，供后续调用。
 */
val myLazyValue: Int by lazy(LazyThreadSafetyMode.NONE) {
    println("hello world")
    30
}

fun main() {
    println(myLazyValue)//hello world 30
    println(myLazyValue)//30
}
/**
 * LazyThreadSafetyMode 延迟线程安全模式
 * SYNCHRONIZED 有一个锁，可以保证只有一个线程初始化实例。默认延迟属性的计算是同步的：值只会在一个线程中计算，其他线程使用结果。
 * PUBLICATION 初始化器函数可以被调用多次，并且是并发访问。但是只有第一次调用的返回值作为延迟属性的结果。
 * NONE 没有锁。可以减少线程安全的开销，但是确保它只会在一个线程中执行。
 */