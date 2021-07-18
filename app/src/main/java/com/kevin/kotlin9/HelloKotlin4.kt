package com.kevin.kotlin9

import java.io.FileNotFoundException
import kotlin.jvm.Throws

/**
 * other：Kevin
 * create time：2021/7/18
 * describe：
 */
class MyClass3 {
    @Throws(FileNotFoundException::class)
    fun method() {
        println("method invoked")
        throw FileNotFoundException()
    }
}
/**
 * java调用kotlin方法的非运行时异常，在kotlin中不存在非运行时异常（checked exception）。
 * 如果kotlin的方法抛出一个非运行时异常，不能像java的写法，在方法的后面写throw FileNotFoundException，
 * 而是写在方法体的最后一行，java调用kotlin有异常的方法时，用try-catch抛出异常FileNotFoundException，编译会报错。
 * 编译时报错：
 * Exception 'java.io.FileNotFoundException' is never thrown in the corresponding try block
 * 译：没有在相应的语句块中抛出FileNotFoundException异常。
 * 没有在方法名字上抛出异常，又不能去捕获。
 * 解决：在kotlin需要抛出异常的地方用注解:@Throws(xxxException::class)
 */